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

import com.example.go.entities.Course;
import com.example.go.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	

	@PostMapping
	List<Course> create(@RequestBody Course course){
		return courseService.create(course);
	}
	
	@GetMapping
	List<Course> list(){
		return courseService.list();
	}
	
	@PutMapping
	List<Course> update(@RequestBody Course course){
		return courseService.update(course);
	}
	
	@DeleteMapping("{id}")
	List<Course> delete(@PathVariable("id") String id){
		return courseService.delete(id);
	}

}
