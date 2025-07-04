package br.com.brenno.reservation_management.infrastructure.repositories;

import br.com.brenno.reservation_management.domain.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
