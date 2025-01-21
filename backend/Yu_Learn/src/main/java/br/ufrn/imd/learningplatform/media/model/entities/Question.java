package br.ufrn.imd.learningplatform.media.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @ManyToOne
    @JsonIgnore
    private Questionnaire questionnaire;

    public Question() {
    }

    public Question(String id, String content, List<Answer> answers, Questionnaire questionnaire) {
        this.id = id;
        this.content = content;
        this.answers = answers;
        this.questionnaire = questionnaire;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question)) return false;
        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
