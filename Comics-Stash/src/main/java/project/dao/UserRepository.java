package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
