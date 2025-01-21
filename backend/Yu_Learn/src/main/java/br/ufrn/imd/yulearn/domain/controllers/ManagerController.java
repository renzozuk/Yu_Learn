package br.ufrn.imd.yulearn.domain.controllers;

import br.ufrn.imd.yulearn.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.yulearn.domain.model.dto.ManagerDTO;
import br.ufrn.imd.yulearn.domain.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers() {
        return new ResponseEntity<>(managerService.getAllManagers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable String id) {
        return new ResponseEntity<>(managerService.getManagerById(id), HttpStatus.OK);
    }

    @PostMapping("/{organizationId}")
    public ResponseEntity<ManagerDTO> createManager(@PathVariable String organizationId, @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(managerService.createManager(organizationId, registerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> updateManager(@RequestBody ManagerDTO managerDTO, @PathVariable String id) {
        return new ResponseEntity<>(managerService.updateManager(managerDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
