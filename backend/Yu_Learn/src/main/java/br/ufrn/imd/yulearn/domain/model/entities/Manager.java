package br.ufrn.imd.yulearn.domain.model.entities;

import br.ufrn.imd.yulearn.authentication.model.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends User {
}
