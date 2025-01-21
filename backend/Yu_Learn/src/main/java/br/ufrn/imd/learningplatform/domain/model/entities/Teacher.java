package br.ufrn.imd.learningplatform.domain.model.entities;

import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.media.model.entities.Lesson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends User {

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "teachers_lessons",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseForeignKey = @ForeignKey(name = "lesson_id") // Revisar depois
    )
    private List<Lesson> lessons;

    public Teacher() {
    }

    public Teacher(String name, String email, String password, Role role) {
        super(name, email, password, role);
        lessons = new ArrayList<>();
    }

    public Teacher(String id, String name, String email, String password, Role role, Organization organization) {
        super(id, name, email, password, role, organization);
        lessons = new ArrayList<>();
    }

    public Teacher(String id, String name, String email, String password, Role role, Organization organization, List<Lesson> lessons) {
        super(id, name, email, password, role, organization);
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
