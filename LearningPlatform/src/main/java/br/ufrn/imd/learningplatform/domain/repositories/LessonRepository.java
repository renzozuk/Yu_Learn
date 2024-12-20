package br.ufrn.imd.learningplatform.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.learningplatform.media.model.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String>{
	
}
