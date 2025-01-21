package br.ufrn.imd.yulearn.media.repositories;

import br.ufrn.imd.yulearn.media.model.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, String>{ }