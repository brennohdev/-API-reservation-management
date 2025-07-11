package br.com.brenno.reservation_management.infrastructure.repositories;

import br.com.brenno.reservation_management.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
