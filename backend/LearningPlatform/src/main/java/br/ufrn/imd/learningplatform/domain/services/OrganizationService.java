package br.ufrn.imd.learningplatform.domain.services;

import br.ufrn.imd.learningplatform.domain.model.dto.OrganizationDTO;
import br.ufrn.imd.learningplatform.domain.model.entities.Organization;
import br.ufrn.imd.learningplatform.domain.repositories.OrganizationRepository;
import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final MyModelMapper mapper;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, MyModelMapper mapper) {
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
    }

    public List<OrganizationDTO> getAllOrganizations() {
        return mapper.convertList(organizationRepository.findAll(), OrganizationDTO.class);
    }

    public OrganizationDTO getOrganizationById(String id) {

        var organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found."));

        return mapper.convertValue(organization, OrganizationDTO.class);
    }

    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {

        var organization = mapper.convertValue(organizationDTO, Organization.class);

        var createdOrganization = organizationRepository.save(organization);

        return mapper.convertValue(createdOrganization, OrganizationDTO.class);
    }

    public OrganizationDTO updateOrganization(OrganizationDTO organizationDTO, String id) {

        var organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found."));

        organization.setName(organizationDTO.getName());

        var updatedOrganization = organizationRepository.save(organization);

        return mapper.convertValue(updatedOrganization, OrganizationDTO.class);
    }

    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }
}
