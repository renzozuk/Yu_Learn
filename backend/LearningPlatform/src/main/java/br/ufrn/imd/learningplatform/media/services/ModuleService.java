package br.ufrn.imd.learningplatform.media.services;

import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import br.ufrn.imd.learningplatform.media.model.dto.ModuleDTO;
import br.ufrn.imd.learningplatform.media.model.entities.Module;
import br.ufrn.imd.learningplatform.media.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
	
	private ModuleRepository moduleRepository;
	private MyModelMapper myModelMapper;

	@Autowired
	public ModuleService(ModuleRepository moduleRepository, MyModelMapper myModelMapper) {
		this.moduleRepository = moduleRepository;
		this.myModelMapper = myModelMapper;
	}

	public List<ModuleDTO> findAll() {
		List<Module> modules = moduleRepository.findAll();

		return myModelMapper.convertList(modules, ModuleDTO.class);
	}

	public ModuleDTO findById(String id) {

		var module = moduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Module not found"));

		return myModelMapper.convertValue(module, ModuleDTO.class);
	}

	public ModuleDTO save(ModuleDTO moduleDTO) {
		var module = myModelMapper.convertValue(moduleDTO, Module.class);
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
