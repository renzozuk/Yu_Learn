package br.ufrn.imd.learningplatform.domain.services;

import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.domain.model.dto.TeacherDTO;
import br.ufrn.imd.learningplatform.domain.model.entities.Teacher;
import br.ufrn.imd.learningplatform.domain.repositories.TeacherRepository;
import br.ufrn.imd.learningplatform.mapper.modelMapper.MyModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final MyModelMapper mapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, MyModelMapper mapper) {
        this.teacherRepository = teacherRepository;
        this.mapper = mapper;
    }

    public List<TeacherDTO> getAllTeachers() {
        return mapper.convertList(this.teacherRepository.findAll(), TeacherDTO.class);
    }

    public TeacherDTO getTeacherById(String id) {

        var teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found."));

        return mapper.convertValue(teacher, TeacherDTO.class);
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {

        var teacher = mapper.convertValue(teacherDTO, Teacher.class);

        teacher.setRole(Role.ROLE_TEACHER);

        var createdTeacher = teacherRepository.save(teacher);

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
