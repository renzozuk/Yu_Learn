package br.ufrn.imd.learningplatform.media.repositories;

import br.ufrn.imd.learningplatform.media.model.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, String>{
	
}
