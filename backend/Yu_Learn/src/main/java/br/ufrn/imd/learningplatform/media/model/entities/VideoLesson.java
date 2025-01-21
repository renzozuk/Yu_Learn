package br.ufrn.imd.learningplatform.media.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "video_lessons")
public class VideoLesson extends Lesson {

    private String videoUrl;

    public VideoLesson() {
    }

    public VideoLesson(String id, String title, String description, String thumbnailUrl, List<String> categories, Module module, String videoUrl) {
        super(id, title, description, thumbnailUrl, categories, module);
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
