package br.ufrn.imd.learningplatform.domain.repositories;

import br.ufrn.imd.learningplatform.domain.model.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
}
