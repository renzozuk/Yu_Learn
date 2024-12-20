package br.ufrn.imd.learningplatform.media.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Outros atributos

    // Construtor

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Outros gets e sets

    // Equals e hash code
}
