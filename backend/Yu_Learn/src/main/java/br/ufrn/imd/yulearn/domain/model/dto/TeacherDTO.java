package br.ufrn.imd.yulearn.domain.model.dto;

import br.ufrn.imd.yulearn.authentication.model.dto.UserDTO;
import br.ufrn.imd.yulearn.media.model.dto.LessonDTO;

import java.util.ArrayList;
import java.util.List;

public class TeacherDTO extends UserDTO {

    private List<LessonDTO> lessons;

    public TeacherDTO() {
    }

    public TeacherDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization) {
        super(id, email, name, authorities, organization);
        this.lessons = new ArrayList<>();
    }

    public TeacherDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization, List<LessonDTO> lessons) {
        super(id, email, name, authorities, organization);
        this.lessons = lessons;
    }

    public List<LessonDTO> getLessons() {
        return lessons;
    }
}
