package br.ufrn.imd.learningplatform.media.model.dto;

import java.util.List;

public class VideoLessonDTO extends LessonDTO {

    private String videoUrl;

    public VideoLessonDTO() {
    }

    public VideoLessonDTO(String id, String title, String description, String thumbnailUrl, List<String> categories, String videoUrl) {
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
