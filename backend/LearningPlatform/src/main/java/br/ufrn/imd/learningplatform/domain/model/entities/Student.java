package br.ufrn.imd.learningplatform.domain.model.entities;

import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.media.model.entities.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends User {

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "students_courses",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseForeignKey = @ForeignKey(name = "course_id") // Revisar depois
    )
    private List<Course> courses;

    public Student() {
    }

    public Student(String name, String email, String password, Role role) {
        super(name, email, password, role);
        courses = new ArrayList<>();
    }

    public Student(String id, String name, String email, String password, Role role, Organization organization) {
        super(id, name, email, password, role, organization);
        courses = new ArrayList<>();
    }

    public Student(String id, String name, String email, String password, Role role, Organization organization, List<Course> courses) {
        super(id, name, email, password, role, organization);
        this.courses = courses;
    }
}
