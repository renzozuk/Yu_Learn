package br.ufrn.imd.yulearn.domain.repositories;

import br.ufrn.imd.yulearn.domain.model.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
}
