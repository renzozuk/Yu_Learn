package br.ufrn.imd.yulearn.domain.model.dto;

import br.ufrn.imd.yulearn.authentication.model.dto.UserDTO;
import br.ufrn.imd.yulearn.media.model.dto.CourseDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO extends UserDTO {

    private List<CourseDTO> courses;

    public StudentDTO() {

    }

    public StudentDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization) {
        super(id, email, name, authorities, organization);
        this.courses = new ArrayList<>();
    }

    public StudentDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization, List<CourseDTO> courses) {
        super(id, email, name, authorities, organization);
        this.courses = courses;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }
}
