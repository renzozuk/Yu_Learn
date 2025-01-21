package br.ufrn.imd.yulearn.media.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "questionnaires")
public class Questionnaire extends Lesson {

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    public Questionnaire() {
    }

    public Questionnaire(String id, String title, String description, String thumbnailUrl, List<String> categories, Module module, List<Question> questions) {
        super(id, title, description, thumbnailUrl, categories, module);
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
