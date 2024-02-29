package fr.bby.polytech.repository;

import fr.bby.polytech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
