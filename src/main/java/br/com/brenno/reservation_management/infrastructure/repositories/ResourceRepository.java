package br.com.brenno.reservation_management.infrastructure.repositories;

import br.com.brenno.reservation_management.domain.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

  Optional<Resource> findByName(String name);
}
