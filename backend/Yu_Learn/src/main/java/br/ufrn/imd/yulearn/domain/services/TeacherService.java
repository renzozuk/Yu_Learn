package br.ufrn.imd.yulearn.domain.services;

import br.ufrn.imd.yulearn.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.yulearn.authentication.model.enums.Role;
import br.ufrn.imd.yulearn.authentication.services.AuthService;
import br.ufrn.imd.yulearn.domain.model.dto.TeacherDTO;
import br.ufrn.imd.yulearn.domain.model.entities.Teacher;
import br.ufrn.imd.yulearn.domain.repositories.OrganizationRepository;
import br.ufrn.imd.yulearn.domain.repositories.TeacherRepository;
import br.ufrn.imd.yulearn.mapper.modelMapper.MyModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final OrganizationRepository organizationRepository;
    private final MyModelMapper mapper;
    private final AuthService authService;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, OrganizationRepository organizationRepository, MyModelMapper mapper, AuthService authService) {
        this.teacherRepository = teacherRepository;
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
        this.authService = authService;
    }

    public List<TeacherDTO> getAllTeachers() {
        return mapper.convertList(this.teacherRepository.findAll(), TeacherDTO.class);
    }

    public TeacherDTO getTeacherById(String id) {

        var teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found."));

        return mapper.convertValue(teacher, TeacherDTO.class);
    }

    public TeacherDTO createTeacher(String organizationId, RegisterRequest registerRequest) {

        var organization = organizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization not found."));

        var teacher = mapper.convertValue(registerRequest, Teacher.class);
        teacher.setPassword(authService.encodePassword(registerRequest.getPassword()));
        teacher.setRole(Role.ROLE_TEACHER);
        teacher.setOrganization(organization);

        var createdTeacher = teacherRepository.save(teacher);

        organization.getUsers().add(createdTeacher);

        organizationRepository.save(organization);

        return mapper.convertValue(createdTeacher, TeacherDTO.class);
    }

    public TeacherDTO updateTeacher(TeacherDTO teacherDTO, String id) {

        var teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found."));

        teacher.setEmail(teacherDTO.getEmail());
        teacher.setName(teacherDTO.getName());

        var updatedTeacher = teacherRepository.save(teacher);

        return mapper.convertValue(updatedTeacher, TeacherDTO.class);
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }
}
