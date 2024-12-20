package br.ufrn.imd.learningplatform.media.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.go.entities.Lesson;
import com.example.go.services.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {
	
	private LessonService lessonService;
	
	public LessonController(LessonService lessonService) {
		this.lessonService = lessonService;
	}
	

	@PostMapping
	List<Lesson> create(@RequestBody Lesson lesson){
		return lessonService.create(lesson);
	}
	
	@GetMapping
	List<Lesson> list(){
		return lessonService.list();
	}
	
	@PutMapping
	List<Lesson> update(@RequestBody Lesson lesson){
		return lessonService.update(lesson);
	}
	
	@DeleteMapping("{id}")
	List<Lesson> delete(@PathVariable("id") String id){
		return lessonService.delete(id);
	}

}
