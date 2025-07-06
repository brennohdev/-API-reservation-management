package br.com.brenno.reservation_management.application.useCases.Resource;

import br.com.brenno.reservation_management.domain.entities.Resource;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceNotFoundException;
import br.com.brenno.reservation_management.infrastructure.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResourceByIdUseCase {
  private final ResourceRepository resourceRepository;

  public GetResourceByIdUseCase(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public Resource execute(long id) {

    return resourceRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "A resource with the ID '" + id + "' was not found."
        ));
  }
}

