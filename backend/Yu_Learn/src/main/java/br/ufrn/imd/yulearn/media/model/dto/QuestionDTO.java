package br.ufrn.imd.yulearn.media.model.dto;

import java.util.List;
import java.util.Objects;

public class QuestionDTO {

    private String id;
    private String content;
    private List<AnswerDTO> answers;

    public QuestionDTO() {
    }

    public QuestionDTO(String id, String content, List<AnswerDTO> answers) {
        this.id = id;
        this.content = content;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
