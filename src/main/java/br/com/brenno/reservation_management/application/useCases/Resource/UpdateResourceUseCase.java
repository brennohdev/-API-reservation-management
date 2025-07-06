package br.com.brenno.reservation_management.application.useCases.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.UpdateResourceDTO;
import br.com.brenno.reservation_management.domain.entities.Resource;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceNotFoundException;
import br.com.brenno.reservation_management.infrastructure.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateResourceUseCase {
  private final ResourceRepository resourceRepository;

  public UpdateResourceUseCase(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public Resource execute(Long id, UpdateResourceDTO dto) {
    Resource existingResource = resourceRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resource with id '" + id + "' not found."));

    existingResource.updateInfo(
        dto.name(),
        dto.description(),
        dto.capacity()
    );

    return resourceRepository.save(existingResource);
  }
}
