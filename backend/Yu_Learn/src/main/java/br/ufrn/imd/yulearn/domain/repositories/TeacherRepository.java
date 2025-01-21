package br.ufrn.imd.yulearn.domain.repositories;

import br.ufrn.imd.yulearn.domain.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
