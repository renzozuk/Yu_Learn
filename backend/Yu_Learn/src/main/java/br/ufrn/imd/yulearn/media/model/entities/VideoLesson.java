package br.ufrn.imd.yulearn.media.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "video_lessons")
public class VideoLesson extends Lesson {

    private String videoUrl;

    public VideoLesson() {
        super();
    }

    public VideoLesson(String id, String title, String description, String thumbnailUrl, List<String> categories, String videoUrl) {
        super(id, title, description, thumbnailUrl, categories);
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
