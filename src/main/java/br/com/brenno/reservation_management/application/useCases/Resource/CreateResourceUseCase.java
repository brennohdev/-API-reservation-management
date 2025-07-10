package br.com.brenno.reservation_management.application.useCases.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.Resource.CreateResourceValidation;
import br.com.brenno.reservation_management.domain.entities.Resource;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceAlreadyExistsException;
import br.com.brenno.reservation_management.infrastructure.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateResourceUseCase {
  private final ResourceRepository resourceRepository;

  public CreateResourceUseCase(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public Resource execute(CreateResourceValidation dto) {
    Optional<Resource> existingResource = resourceRepository.findByName(dto.getName());

    if (existingResource.isPresent()) {
      throw new ResourceAlreadyExistsException(
          "A resource with the name '" + dto.getName() + "' already exists.");
    }

    Resource newResource = new Resource(
        dto.getName(),
        dto.getDescription(),
        dto.getCapacity()
    );

    return this.resourceRepository.save(newResource);
  }
}
