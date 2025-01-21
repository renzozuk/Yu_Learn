package br.ufrn.imd.yulearn.media.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "text_lessons")
public class TextLesson extends Lesson {

    private String pdfUrl;

    public TextLesson() {
        super();
    }

    public TextLesson(String id, String title, String description, String thumbnailUrl, List<String> categories, Module module, String pdfUrl) {
        super(id, title, description, thumbnailUrl, categories, module);
        this.pdfUrl = pdfUrl;
    }


    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
