package br.ufrn.imd.learningplatform.media.model.dto;

import java.util.Objects;

public class AnswerDTO {

    private String id;
    private boolean isCorrect;
    private String content;

    public AnswerDTO() {
    }

    public AnswerDTO(String id, boolean isCorrect, String content) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerDTO answerDTO)) return false;
        return Objects.equals(id, answerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
