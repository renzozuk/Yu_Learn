package br.ufrn.imd.learningplatform.domain.controllers;

import br.ufrn.imd.learningplatform.domain.model.dto.OrganizationDTO;
import br.ufrn.imd.learningplatform.domain.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        return new ResponseEntity<>(organizationService.getAllOrganizations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable String id) {
        return new ResponseEntity<>(organizationService.getOrganizationById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return new ResponseEntity<>(organizationService.createOrganization(organizationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@RequestBody OrganizationDTO organizationDTO, @PathVariable String id) {
        return new ResponseEntity<>(organizationService.updateOrganization(organizationDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
