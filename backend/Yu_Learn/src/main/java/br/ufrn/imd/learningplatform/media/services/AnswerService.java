package br.ufrn.imd.learningplatform.media.services;

import br.ufrn.imd.learningplatform.mapper.Mapper;
import br.ufrn.imd.learningplatform.media.model.dto.AnswerDTO;
import br.ufrn.imd.learningplatform.media.model.entities.Answer;
import br.ufrn.imd.learningplatform.media.repositories.AnswerRepository;
import br.ufrn.imd.learningplatform.media.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final Mapper mapper;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, Mapper mapper) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.mapper = mapper;
    }

    public List<AnswerDTO> getAllAnswers() {
        return mapper.convertList(answerRepository.findAll(), AnswerDTO.class);
    }

    public AnswerDTO getAnswerById(String id) {

        var answer = answerRepository.findById(id).orElseThrow(() -> new RuntimeException("Answer not found."));

        return mapper.convertValue(answer, AnswerDTO.class);
    }

    public AnswerDTO createAnswer(String questionId, AnswerDTO answerDTO) {

        var question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found."));

        var answer = mapper.convertValue(answerDTO, Answer.class);
        answer.setQuestion(question);

        var createdAnswer = answerRepository.save(answer);

        question.getAnswers().add(createdAnswer);

        return mapper.convertValue(createdAnswer, AnswerDTO.class);
    }

    public AnswerDTO updateAnswer(AnswerDTO answerDTO, String id) {

        var answer = answerRepository.findById(id).orElseThrow(() -> new RuntimeException("Answer not found."));

        answer.setCorrect(answerDTO.isCorrect());
        answer.setContent(answerDTO.getContent());

        var updatedAnswer = mapper.convertValue(answer, Answer.class);

        return mapper.convertValue(updatedAnswer, AnswerDTO.class);
    }

    public void deleteAnswer(String id) {
        answerRepository.deleteById(id);
    }
}
