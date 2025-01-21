package br.ufrn.imd.yulearn.media.services;

import br.ufrn.imd.yulearn.mapper.modelMapper.MyModelMapper;
import br.ufrn.imd.yulearn.media.model.dto.LessonDTO;
import br.ufrn.imd.yulearn.media.model.entities.Lesson;
import br.ufrn.imd.yulearn.media.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

	private LessonRepository lessonRepository;
	private MyModelMapper myModelMapper;

	@Autowired
	public LessonService(LessonRepository lessonRepository, MyModelMapper myModelMapper) {
		this.lessonRepository = lessonRepository;
		this.myModelMapper = myModelMapper;
	}

	public List<LessonDTO> findAll() {
		List<Lesson> lessons = lessonRepository.findAll();
		return myModelMapper.convertList(lessons, LessonDTO.class);
	}

	public LessonDTO findById(String id) {
		var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));

		return myModelMapper.convertValue(lesson, LessonDTO.class);
	}

	public LessonDTO save(LessonDTO lessonDTO) {
		var lesson = myModelMapper.convertValue(lessonDTO, Lesson.class);
		return myModelMapper.convertValue(lessonRepository.save(lesson), LessonDTO.class);
	}

	public LessonDTO update(LessonDTO lessonDTO) {
		var lesson = lessonRepository.findById(lessonDTO.getId()).orElseThrow(() -> new RuntimeException("Lesson not found"));

		lesson.setTitle(lessonDTO.getTitle());
		lesson.setDescription(lessonDTO.getDescription());
		lesson.setCategories(lessonDTO.getCategories());
		lesson.setThumbnailUrl(lessonDTO.getThumbnailUrl());

		return myModelMapper.convertValue(lessonRepository.save(lesson), LessonDTO.class);
	}

	public void delete(String id) {
		lessonRepository.deleteById(id);
	}

}
