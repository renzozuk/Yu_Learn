package br.ufrn.imd.learningplatform.media.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
    private String description;
    private String thumbnailUrl;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<>();

    public Module() {}

    public Module(String id, String title, String description, String thumbnailUrl, List<Lesson> lessons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.lessons = lessons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
