package br.ufrn.imd.learningplatform.media.services;

import br.ufrn.imd.learningplatform.mapper.Mapper;
import br.ufrn.imd.learningplatform.media.model.dto.QuestionDTO;
import br.ufrn.imd.learningplatform.media.model.entities.Question;
import br.ufrn.imd.learningplatform.media.model.entities.Questionnaire;
import br.ufrn.imd.learningplatform.media.repositories.LessonRepository;
import br.ufrn.imd.learningplatform.media.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private LessonRepository lessonRepository;
    private Mapper mapper;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, LessonRepository lessonRepository, Mapper mapper) {
        this.questionRepository = questionRepository;
        this.lessonRepository = lessonRepository;
        this.mapper = mapper;
    }

    public List<QuestionDTO> getAllQuestions() {
        return mapper.convertList(questionRepository.findAll(), QuestionDTO.class);
    }

    public QuestionDTO getQuestionById(String id) {
        return mapper.convertValue(questionRepository.findById(id), QuestionDTO.class);
    }

    public QuestionDTO createQuestion(String questionnaireId, QuestionDTO questionDTO) {

        var lesson = lessonRepository.findById(questionnaireId).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof Questionnaire)) {
            throw new RuntimeException("Lesson is not a questionnaire.");
        }
        var questionnaire = (Questionnaire) lesson;

        var question = mapper.convertValue(questionDTO, Question.class);
        question.setQuestionnaire(questionnaire);

        var createdQuestion = questionRepository.save(question);

        questionnaire.getQuestions().add(createdQuestion);

        return mapper.convertValue(createdQuestion, QuestionDTO.class);
    }

    public QuestionDTO updateQuestion(QuestionDTO questionDTO, String id) {

        var question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found."));

        question.setContent(questionDTO.getContent());

        var updatedQuestion = questionRepository.save(question);

        return mapper.convertValue(updatedQuestion, QuestionDTO.class);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }
}
