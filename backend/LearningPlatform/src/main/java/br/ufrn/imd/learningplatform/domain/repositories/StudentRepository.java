package br.ufrn.imd.learningplatform.domain.repositories;

import br.ufrn.imd.learningplatform.domain.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
