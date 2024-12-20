package br.ufrn.imd.learningplatform.domain.model.entities;

import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends User {
}
