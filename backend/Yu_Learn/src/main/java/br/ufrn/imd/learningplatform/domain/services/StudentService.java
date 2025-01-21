package br.ufrn.imd.learningplatform.domain.services;

import br.ufrn.imd.learningplatform.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.authentication.services.AuthService;
import br.ufrn.imd.learningplatform.domain.model.dto.StudentDTO;
import br.ufrn.imd.learningplatform.domain.model.entities.Student;
import br.ufrn.imd.learningplatform.domain.repositories.OrganizationRepository;
import br.ufrn.imd.learningplatform.domain.repositories.StudentRepository;
import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final OrganizationRepository organizationRepository;
    private final MyModelMapper mapper;
    private final AuthService authService;

    @Autowired
    public StudentService(StudentRepository studentRepository, OrganizationRepository organizationRepository, MyModelMapper mapper, AuthService authService) {
        this.studentRepository = studentRepository;
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
        this.authService = authService;
    }

    public List<StudentDTO> getAllStudents() {
        return mapper.convertList(studentRepository.findAll(), StudentDTO.class);
    }

    public StudentDTO getStudentById(String id) {

        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found."));

        return mapper.convertValue(student, StudentDTO.class);
    }

    public StudentDTO createStudent(String organizationId, RegisterRequest registerRequest) {

        var organization = organizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization not found."));

        var student = mapper.convertValue(registerRequest, Student.class);
        student.setPassword(authService.encodePassword(registerRequest.getPassword()));
        student.setRole(Role.ROLE_STUDENT);
        student.setOrganization(organization);

        var createdStudent = studentRepository.save(student);

        organization.getUsers().add(createdStudent);

        organizationRepository.save(organization);

        return mapper.convertValue(createdStudent, StudentDTO.class);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO, String id) {

        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found."));

        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());

        var updatedStudent = studentRepository.save(student);

        return mapper.convertValue(updatedStudent, StudentDTO.class);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
