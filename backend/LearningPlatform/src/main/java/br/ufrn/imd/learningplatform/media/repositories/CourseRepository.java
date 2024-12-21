package br.ufrn.imd.learningplatform.media.repositories;

import br.ufrn.imd.learningplatform.media.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{

}
