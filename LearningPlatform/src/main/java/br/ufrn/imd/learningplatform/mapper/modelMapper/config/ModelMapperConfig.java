package br.ufrn.imd.learningplatform.mapper.modelMapper.config;

import br.ufrn.imd.learningplatform.authentication.model.dto.UserDTO;
import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import br.ufrn.imd.learningplatform.domain.model.dto.ManagerDTO;
import br.ufrn.imd.learningplatform.domain.model.dto.OrganizationDTO;
import br.ufrn.imd.learningplatform.domain.model.dto.StudentDTO;
import br.ufrn.imd.learningplatform.domain.model.dto.TeacherDTO;
import br.ufrn.imd.learningplatform.domain.model.entities.Manager;
import br.ufrn.imd.learningplatform.domain.model.entities.Organization;
import br.ufrn.imd.learningplatform.domain.model.entities.Student;
import br.ufrn.imd.learningplatform.domain.model.entities.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Organization.class, OrganizationDTO.class)
                .addMapping(Organization::getId, OrganizationDTO::setId);

        modelMapper.createTypeMap(OrganizationDTO.class, Organization.class)
                .addMapping(OrganizationDTO::getId, Organization::setId);

        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMapping(User::getId, UserDTO::setId);

        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMapping(UserDTO::getId, User::setId);

        modelMapper.createTypeMap(Manager.class, ManagerDTO.class)
                .addMapping(Manager::getId, ManagerDTO::setId); // Pode ser removido, caso não seja necessário

        modelMapper.createTypeMap(ManagerDTO.class, Manager.class)
                .addMapping(ManagerDTO::getId, Manager::setId); // Pode ser removido, caso não seja necessário

        modelMapper.createTypeMap(Student.class, StudentDTO.class)
                .addMapping(Student::getId, StudentDTO::setId); // Pode ser removido, caso não seja necessário

        modelMapper.createTypeMap(StudentDTO.class, Student.class)
                .addMapping(StudentDTO::getId, Student::setId); // Pode ser removido, caso não seja necessário

        modelMapper.createTypeMap(Teacher.class, TeacherDTO.class)
                .addMapping(Teacher::getId, TeacherDTO::setId); // Pode ser removido, caso não seja necessário

        modelMapper.createTypeMap(TeacherDTO.class, Teacher.class)
                .addMapping(TeacherDTO::getId, Teacher::setId); // Pode ser removido, caso não seja necessário

        return modelMapper;
    }
}
