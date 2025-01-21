package br.ufrn.imd.yulearn.media.repositories;

import br.ufrn.imd.yulearn.media.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
