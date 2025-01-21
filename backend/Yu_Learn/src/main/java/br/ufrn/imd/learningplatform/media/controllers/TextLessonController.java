package br.ufrn.imd.learningplatform.media.controllers;

import br.ufrn.imd.learningplatform.media.model.dto.TextLessonDTO;
import br.ufrn.imd.learningplatform.media.services.TextLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/textlessons", "/api/text-lessons", "/api/text_lessons"})
public class TextLessonController {

    @Autowired
    private TextLessonService textLessonService;

    @GetMapping
    public ResponseEntity<List<TextLessonDTO>> getAllTextLessons() {
        return new ResponseEntity<>(textLessonService.getAllTextLessons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextLessonDTO> getTextLessonById(@PathVariable String id) {
        return new ResponseEntity<>(textLessonService.getTextLessonById(id), HttpStatus.OK);
    }

    @PostMapping("/{moduleId}")
    public ResponseEntity<TextLessonDTO> createTextLesson(@PathVariable String moduleId, @RequestBody TextLessonDTO textLessonDTO) {
        return new ResponseEntity<>(textLessonService.createTextLesson(moduleId, textLessonDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TextLessonDTO> updateTextLesson(@RequestBody TextLessonDTO textLessonDTO, @PathVariable String id) {
        return new ResponseEntity<>(textLessonService.updateTextLesson(textLessonDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTextLesson(@PathVariable String id) {
        textLessonService.deleteTextLesson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
