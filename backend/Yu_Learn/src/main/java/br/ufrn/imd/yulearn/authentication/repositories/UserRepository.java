package br.ufrn.imd.yulearn.authentication.repositories;

import br.ufrn.imd.yulearn.authentication.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
