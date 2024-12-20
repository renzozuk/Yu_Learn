package br.ufrn.imd.learningplatform.domain.services;

import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.domain.model.dto.StudentDTO;
import br.ufrn.imd.learningplatform.domain.model.entities.Student;
import br.ufrn.imd.learningplatform.domain.repositories.StudentRepository;
import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final MyModelMapper mapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, MyModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<StudentDTO> getAllStudents() {
        return mapper.convertList(studentRepository.findAll(), StudentDTO.class);
    }

    public StudentDTO getStudentById(String id) {

        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found."));

        return mapper.convertValue(student, StudentDTO.class);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {

        var student = mapper.convertValue(studentDTO, Student.class);

        student.setRole(Role.ROLE_STUDENT);

        var createdStudent = studentRepository.save(student);

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
