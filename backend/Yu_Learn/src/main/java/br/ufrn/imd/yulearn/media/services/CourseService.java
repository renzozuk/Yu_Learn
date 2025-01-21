package br.ufrn.imd.yulearn.media.services;

import br.ufrn.imd.yulearn.mapper.modelMapper.MyModelMapper;
import br.ufrn.imd.yulearn.media.model.dto.CourseDTO;
import br.ufrn.imd.yulearn.media.model.entities.Course;
import br.ufrn.imd.yulearn.media.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
	
	private final CourseRepository courseRepository;
	private final MyModelMapper modelMapper;

	@Autowired
	public CourseService(CourseRepository courseRepository, MyModelMapper modelMapper) {
		this.courseRepository = courseRepository;
		this.modelMapper = modelMapper;
	}

	public List<CourseDTO> findAll(){
		return modelMapper.convertList(courseRepository.findAll(), CourseDTO.class);
	}

	public CourseDTO findById(String courseId) {
		var course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

		return modelMapper.convertValue(course, CourseDTO.class);
	}

	public CourseDTO create(CourseDTO courseDTO){

		var course = modelMapper.convertValue(courseDTO, Course.class);

		return modelMapper.convertValue(courseRepository.save(course), CourseDTO.class);
	}

	public CourseDTO update(CourseDTO courseDTO){

		var course = courseRepository.findById(courseDTO.getId()).orElseThrow(() -> new RuntimeException("Course not found"));

		course.setTitle(courseDTO.getTitle());
		course.setDescription(courseDTO.getDescription());
		course.setThumbnailUrl(courseDTO.getThumbnailUrl());

		return modelMapper.convertValue(courseRepository.save(course), CourseDTO.class);
	}
	
	public void delete(String id){
		courseRepository.deleteById(id);
	}

}
