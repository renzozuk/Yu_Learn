package br.ufrn.imd.learningplatform.media.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class LessonDTO implements Serializable {
    private String id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private List<String> categories;

    public LessonDTO(String id, String title, String description, String thumbnailUrl, List<String> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LessonDTO lessonDTO = (LessonDTO) o;
        return Objects.equals(id, lessonDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}