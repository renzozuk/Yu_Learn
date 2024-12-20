package br.ufrn.imd.learningplatform.authentication.repositories;

import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
