package br.ufrn.imd.yulearn.domain.services;

import br.ufrn.imd.yulearn.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.yulearn.authentication.model.enums.Role;
import br.ufrn.imd.yulearn.authentication.services.AuthService;
import br.ufrn.imd.yulearn.domain.model.dto.ManagerDTO;
import br.ufrn.imd.yulearn.domain.model.entities.Manager;
import br.ufrn.imd.yulearn.domain.repositories.ManagerRepository;
import br.ufrn.imd.yulearn.domain.repositories.OrganizationRepository;
import br.ufrn.imd.yulearn.mapper.modelMapper.MyModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final OrganizationRepository organizationRepository;
    private final MyModelMapper mapper;
    private final AuthService authService;

    @Autowired
    public ManagerService(ManagerRepository managerRepository, OrganizationRepository organizationRepository, MyModelMapper mapper, AuthService authService) {
        this.managerRepository = managerRepository;
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
        this.authService = authService;
    }

    public List<ManagerDTO> getAllManagers() {
        return mapper.convertList(managerRepository.findAll(), ManagerDTO.class);
    }

    public ManagerDTO getManagerById(String id) {

        var manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found."));

        return mapper.convertValue(manager, ManagerDTO.class);
    }

    public ManagerDTO createManager(String organizationId, RegisterRequest registerRequest) {

        var organization = organizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization not found."));

        var manager = mapper.convertValue(registerRequest, Manager.class);
        manager.setPassword(authService.encodePassword(registerRequest.getPassword()));
        manager.setRole(Role.ROLE_MANAGER);
        manager.setOrganization(organization);

        var createdManager = managerRepository.save(manager);

        organization.getUsers().add(createdManager);

        organizationRepository.save(organization);

        return mapper.convertValue(createdManager, ManagerDTO.class);
    }

    public ManagerDTO updateManager(ManagerDTO managerDTO, String id) {

        var manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found."));

        manager.setEmail(managerDTO.getEmail());
        manager.setName(managerDTO.getName());

        var updatedManager = managerRepository.save(manager);

        return mapper.convertValue(updatedManager, ManagerDTO.class);
    }

    public void deleteManager(String id) {
        managerRepository.deleteById(id);
    }
}
