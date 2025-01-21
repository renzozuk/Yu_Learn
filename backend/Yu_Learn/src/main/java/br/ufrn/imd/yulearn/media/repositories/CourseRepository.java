package br.ufrn.imd.yulearn.media.repositories;

import br.ufrn.imd.yulearn.media.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{ }