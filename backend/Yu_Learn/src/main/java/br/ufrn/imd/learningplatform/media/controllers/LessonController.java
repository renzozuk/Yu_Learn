package br.ufrn.imd.learningplatform.media.controllers;

import br.ufrn.imd.learningplatform.media.model.dto.LessonDTO;
import br.ufrn.imd.learningplatform.media.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

	private final LessonService lessonService;

	@Autowired
	public LessonController(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	@GetMapping
	public ResponseEntity<List<LessonDTO>> getAllLessons() {
		List<LessonDTO> lessons = lessonService.findAll();
		return ResponseEntity.ok(lessons);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LessonDTO> getLessonById(@PathVariable String id) {
		LessonDTO lesson = lessonService.findById(id);
		return ResponseEntity.ok(lesson);
	}

	@PostMapping
	public ResponseEntity<LessonDTO> createLesson(@RequestBody LessonDTO lessonDTO) {
		LessonDTO createdLesson = lessonService.save(lessonDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdLesson);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LessonDTO> updateLesson(@RequestBody LessonDTO lessonDTO) {
		LessonDTO updatedLesson = lessonService.update(lessonDTO);
		return ResponseEntity.ok(updatedLesson);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLesson(@PathVariable String id) {
		lessonService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
