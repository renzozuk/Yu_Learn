package br.ufrn.imd.learningplatform.media.repositories;

import br.ufrn.imd.learningplatform.media.model.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, String> {
}
