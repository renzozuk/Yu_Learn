package br.ufrn.imd.learningplatform.media.services;

import br.ufrn.imd.learningplatform.mapper.Mapper;
import br.ufrn.imd.learningplatform.media.model.dto.TextLessonDTO;
import br.ufrn.imd.learningplatform.media.model.entities.TextLesson;
import br.ufrn.imd.learningplatform.media.repositories.LessonRepository;
import br.ufrn.imd.learningplatform.media.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextLessonService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;
    private final Mapper mapper;

    @Autowired
    public TextLessonService(LessonRepository lessonRepository, ModuleRepository moduleRepository, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.moduleRepository = moduleRepository;
        this.mapper = mapper;
    }

    public List<TextLessonDTO> getAllTextLessons() {
        return mapper.convertList(lessonRepository.findAll().stream().filter(lesson -> lesson instanceof TextLesson).toList(), TextLessonDTO.class);
    }

    public TextLessonDTO getTextLessonById(String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof TextLesson)) {
            throw new RuntimeException("Lesson found is not a TextLesson.");
        }

        var textLesson = (TextLesson) lesson;

        return mapper.convertValue(textLesson, TextLessonDTO.class);
    }

    public TextLessonDTO createTextLesson(String moduleId, TextLessonDTO textLessonDTO) {

        var module = moduleRepository.findById(moduleId).orElseThrow(() -> new RuntimeException("Module not found."));

        var textLesson = mapper.convertValue(textLessonDTO, TextLesson.class);
        textLesson.setModule(module);

        var createdTextLesson = lessonRepository.save(textLesson);

        module.getLessons().add(createdTextLesson);
        moduleRepository.save(module);

        return mapper.convertValue(createdTextLesson, TextLessonDTO.class);
    }

    public TextLessonDTO updateTextLesson(TextLessonDTO textLessonDTO, String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof TextLesson)) {
            throw new RuntimeException("Lesson found is not a TextLesson.");
        }

        var textLesson = (TextLesson) lesson;

        textLesson.setTitle(textLessonDTO.getTitle());
        textLesson.setDescription(textLessonDTO.getDescription());
        textLesson.setThumbnailUrl(textLessonDTO.getThumbnailUrl());
        textLesson.setCategories(textLessonDTO.getCategories());
        textLesson.setPdfUrl(textLessonDTO.getPdfUrl());

        var updatedTextLesson = lessonRepository.save(textLesson);

        return mapper.convertValue(updatedTextLesson, TextLessonDTO.class);
    }

    public void deleteTextLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
