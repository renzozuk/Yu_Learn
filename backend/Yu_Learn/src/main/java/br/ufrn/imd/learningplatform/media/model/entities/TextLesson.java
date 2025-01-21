package br.ufrn.imd.learningplatform.media.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "text_lessons")
public class TextLesson extends Lesson {

    private String pdfUrl;

    public TextLesson() {
    }

    public TextLesson(String id, String title, String description, List<String> categories, String thumbnailUrl, String pdfUrl) {
        super(id, title, description, categories, thumbnailUrl);
        this.pdfUrl = pdfUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
