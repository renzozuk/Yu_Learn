package br.ufrn.imd.learningplatform.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.go.entities.Course;
import com.example.go.repositories.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	
	public List<Course> create(Course course){
		courseRepository.save(course);
		return list();
	}
	
	public List<Course> list(){
		return courseRepository.findAll();
	}
	
	public List<Course> update(Course course){
		courseRepository.save(course);
		return list();
	}
	
	public List<Course> delete(String id){
		courseRepository.deleteById(id);
		return list();
	}


}
