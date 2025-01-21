package br.ufrn.imd.yulearn.media.model.dto;

import java.util.List;

public class QuestionnaireDTO extends LessonDTO {

    private List<QuestionDTO> questions;

    public QuestionnaireDTO() {
    }

    public QuestionnaireDTO(String id, String title, String description, String thumbnailUrl, List<String> categories, List<QuestionDTO> questions) {
        super(id, title, description, thumbnailUrl, categories);
        this.questions = questions;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }
}
