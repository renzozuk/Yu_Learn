package br.ufrn.imd.yulearn.media.model.dto;

import java.util.List;

public class TextLessonDTO extends LessonDTO {

    private String pdfUrl;

    public TextLessonDTO() {
    }

    public TextLessonDTO(String id, String title, String description, String thumbnailUrl, List<String> categories, String pdfUrl) {
        super(id, title, description, thumbnailUrl, categories);
        this.pdfUrl = pdfUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
