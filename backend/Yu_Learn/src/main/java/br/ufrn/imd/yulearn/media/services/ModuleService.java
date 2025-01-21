package br.ufrn.imd.yulearn.media.services;

import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import br.ufrn.imd.learningplatform.media.model.dto.ModuleDTO;
import br.ufrn.imd.learningplatform.media.model.entities.Module;
import br.ufrn.imd.learningplatform.media.repositories.CourseRepository;
import br.ufrn.imd.learningplatform.media.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

	private final CourseRepository courseRepository;
	private ModuleRepository moduleRepository;
	private MyModelMapper myModelMapper;

	@Autowired
	public ModuleService(ModuleRepository moduleRepository, MyModelMapper myModelMapper, CourseRepository courseRepository) {
		this.moduleRepository = moduleRepository;
		this.myModelMapper = myModelMapper;
		this.courseRepository = courseRepository;
	}

	public List<ModuleDTO> findAll() {
		List<Module> modules = moduleRepository.findAll();

		return myModelMapper.convertList(modules, ModuleDTO.class);
	}

	public ModuleDTO findById(String id) {

		var module = moduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Module not found"));

		return myModelMapper.convertValue(module, ModuleDTO.class);
	}

	public ModuleDTO save(String courseId, ModuleDTO moduleDTO) {

		var course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

		var module = myModelMapper.convertValue(moduleDTO, Module.class);

		module.setCourse(course);

		module = moduleRepository.save(module);

		course.getModules().add(module);

		courseRepository.save(course);

		return myModelMapper.convertValue(moduleRepository.save(module), ModuleDTO.class);
	}

	public ModuleDTO update(ModuleDTO moduleDTO) {
		var module = moduleRepository.findById(moduleDTO.getId()).orElseThrow(() -> new RuntimeException("Module not found"));

		module.setTitle(moduleDTO.getTitle());
		module.setDescription(moduleDTO.getDescription());
		module.setThumbnailUrl(moduleDTO.getThumbnailUrl());

		return myModelMapper.convertValue(moduleRepository.save(module), ModuleDTO.class);
	}

	public void delete(String id) {
		moduleRepository.deleteById(id);
	}

}
