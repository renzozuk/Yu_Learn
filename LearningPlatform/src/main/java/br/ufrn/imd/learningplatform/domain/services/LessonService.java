package br.ufrn.imd.learningplatform.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.go.entities.Lesson;
import com.example.go.repositories.LessonRepository;

@Service
public class LessonService {
	
private LessonRepository lessonRepository;
	
	public LessonService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}
	
	
	public List<Lesson> create(Lesson lesson){
		lessonRepository.save(lesson);
		return list();
	}
	
	public List<Lesson> list(){
		return lessonRepository.findAll();
	}
	
	public List<Lesson> update(Lesson lesson){
		lessonRepository.save(lesson);
		return list();
	}
	
	public List<Lesson> delete(String id){
		lessonRepository.deleteById(id);
		return list();
	
	}
}
