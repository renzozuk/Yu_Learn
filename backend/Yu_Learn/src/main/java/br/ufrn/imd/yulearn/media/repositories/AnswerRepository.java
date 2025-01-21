package br.ufrn.imd.yulearn.media.repositories;

import br.ufrn.imd.yulearn.media.model.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, String> {
}
