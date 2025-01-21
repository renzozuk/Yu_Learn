package br.ufrn.imd.yulearn.domain.repositories;

import br.ufrn.imd.yulearn.domain.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
