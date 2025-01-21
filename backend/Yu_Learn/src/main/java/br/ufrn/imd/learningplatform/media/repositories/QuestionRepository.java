package br.ufrn.imd.learningplatform.media.repositories;

import br.ufrn.imd.learningplatform.media.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
