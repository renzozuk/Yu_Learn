package br.ufrn.imd.learningplatform.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.learningplatform.media.model.entities.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

}
