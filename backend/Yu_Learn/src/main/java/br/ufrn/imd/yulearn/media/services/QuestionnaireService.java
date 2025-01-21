package br.ufrn.imd.yulearn.media.services;

import br.ufrn.imd.yulearn.mapper.Mapper;
import br.ufrn.imd.yulearn.media.model.dto.QuestionnaireDTO;
import br.ufrn.imd.yulearn.media.model.entities.Questionnaire;
import br.ufrn.imd.yulearn.media.repositories.LessonRepository;
import br.ufrn.imd.yulearn.media.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;
    private final Mapper mapper;

    @Autowired
    public QuestionnaireService(LessonRepository lessonRepository, ModuleRepository moduleRepository, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.moduleRepository = moduleRepository;
        this.mapper = mapper;
    }

    public List<QuestionnaireDTO> getAllQuestionnaires() {
        return mapper.convertList(lessonRepository.findAll().stream().filter(lesson -> lesson instanceof Questionnaire).toList(), QuestionnaireDTO.class);
    }

    public QuestionnaireDTO getQuestionnaireById(String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof Questionnaire)) {
            throw new RuntimeException("Lesson found is not a Questionnaire.");
        }

        var questionnaire = (Questionnaire) lesson;

        return mapper.convertValue(questionnaire, QuestionnaireDTO.class);
    }

    public QuestionnaireDTO createQuestionnaire(String moduleId, QuestionnaireDTO questionnaireDTO) {

        var module = moduleRepository.findById(moduleId).orElseThrow(() -> new RuntimeException("Module not found."));

        var questionnaire = mapper.convertValue(questionnaireDTO, Questionnaire.class);
        questionnaire.setModule(module);

        var createdQuestionnaire = lessonRepository.save(questionnaire);

        module.getLessons().add(questionnaire);
        moduleRepository.save(module);

        return mapper.convertValue(createdQuestionnaire, QuestionnaireDTO.class);
    }

    public QuestionnaireDTO updateQuestionnaire(QuestionnaireDTO questionnaireDTO, String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof Questionnaire)) {
            throw new RuntimeException("Lesson found is not a Questionnaire.");
        }

        var questionnaire = (Questionnaire) lesson;

        questionnaire.setTitle(questionnaireDTO.getTitle());
        questionnaire.setDescription(questionnaireDTO.getDescription());
        questionnaire.setThumbnailUrl(questionnaireDTO.getThumbnailUrl());
        questionnaire.setCategories(questionnaireDTO.getCategories());

        var updatedQuestionnaire = lessonRepository.save(questionnaire);

        return mapper.convertValue(updatedQuestionnaire, QuestionnaireDTO.class);
    }

    public void deleteQuestionnaire(String id) {
        lessonRepository.deleteById(id);
    }
}
