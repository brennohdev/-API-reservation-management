package br.com.brenno.reservation_management.application.useCases.Resource;

import br.com.brenno.reservation_management.domain.entities.Resource;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceNotFoundException;
import br.com.brenno.reservation_management.infrastructure.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteResourceUseCase {
  private final ResourceRepository resourceRepository;

  public DeleteResourceUseCase(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public void deleteResource(long id) {
    Resource existingResource = resourceRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resource with id '" + id + "' not found."));

    this.resourceRepository.delete(existingResource);
  }

}
