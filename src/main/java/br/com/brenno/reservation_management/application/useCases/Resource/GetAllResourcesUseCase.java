package br.com.brenno.reservation_management.application.useCases.Resource;

import br.com.brenno.reservation_management.domain.entities.Resource;
import br.com.brenno.reservation_management.infrastructure.repositories.ResourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllResourcesUseCase {
  private final ResourceRepository resourceRepository;

  public GetAllResourcesUseCase(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  /**
   * Retrieves all resources from the repository.
   *
   * @param pageable Object containing pagination information given by the client(number page, size, order.
   * @return a list of all resources as a object containing pagination information.
   */
  public Page<Resource> execute(Pageable pageable) {
    return this.resourceRepository.findAll(pageable);
  }

}
