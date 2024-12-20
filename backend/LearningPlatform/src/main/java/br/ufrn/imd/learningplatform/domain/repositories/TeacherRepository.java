package br.ufrn.imd.learningplatform.domain.repositories;

import br.ufrn.imd.learningplatform.domain.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
