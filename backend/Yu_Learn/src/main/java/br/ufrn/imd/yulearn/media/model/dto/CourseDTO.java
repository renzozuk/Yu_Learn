package br.ufrn.imd.yulearn.media.model.dto;

import java.io.Serializable;
import java.util.Objects;


public class CourseDTO implements Serializable {
    private String id;
    private String title;
    private String description;
    private String thumbnailUrl;

    public CourseDTO(String id, String title, String description, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CourseDTO courseDto = (CourseDTO) o;
        return Objects.equals(id, courseDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}