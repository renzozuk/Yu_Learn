package br.ufrn.imd.yulearn.media.controllers;

import br.ufrn.imd.yulearn.media.model.dto.ModuleDTO;
import br.ufrn.imd.yulearn.media.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

	private final ModuleService moduleService;

	@Autowired
	public ModuleController(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@GetMapping
	public ResponseEntity<List<ModuleDTO>> getAllModules() {
		List<ModuleDTO> modules = moduleService.findAll();
		return ResponseEntity.ok(modules);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModuleDTO> getModuleById(@PathVariable String id) {
		ModuleDTO module = moduleService.findById(id);
		return ResponseEntity.ok(module);
	}

	@PostMapping(value = "/{courseId}")
	public ResponseEntity<ModuleDTO> createModule(@PathVariable("courseId") String courseId, @RequestBody ModuleDTO moduleDTO) {
		ModuleDTO createdModule = moduleService.save(courseId, moduleDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdModule);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ModuleDTO> updateModule(@RequestBody ModuleDTO moduleDTO) {
		ModuleDTO updatedModule = moduleService.update(moduleDTO);
		return ResponseEntity.ok(updatedModule);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteModule(@PathVariable String id) {
		moduleService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
