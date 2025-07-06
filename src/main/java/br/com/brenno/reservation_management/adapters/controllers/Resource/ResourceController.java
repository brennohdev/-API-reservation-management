package br.com.brenno.reservation_management.adapters.controllers.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.CreateResourceDTO;
import br.com.brenno.reservation_management.adapters.in.web.dto.UpdateResourceDTO;
import br.com.brenno.reservation_management.application.useCases.Resource.*;
import br.com.brenno.reservation_management.domain.entities.Resource;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
  private final CreateResourceUseCase createResourceUseCase;
  private final GetResourceByIdUseCase getResourceByIdUseCase;
  private final GetAllResourcesUseCase getAllResourcesUseCase;
  private final UpdateResourceUseCase updateResourceUseCase;
  private final DeleteResourceUseCase deleteResourceUseCase;

  public ResourceController(
      CreateResourceUseCase createResourceUseCase,
      GetResourceByIdUseCase getResourceByIdUseCase,
      GetAllResourcesUseCase getAllResourcesUseCase,
      UpdateResourceUseCase updateResourceUseCase,
      DeleteResourceUseCase deleteResourceUseCase) {
    this.createResourceUseCase = createResourceUseCase;
    this.getResourceByIdUseCase = getResourceByIdUseCase;
    this.getAllResourcesUseCase = getAllResourcesUseCase;
    this.updateResourceUseCase = updateResourceUseCase;
    this.deleteResourceUseCase = deleteResourceUseCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Resource create(@RequestBody @Valid CreateResourceDTO dto) {

    return this.createResourceUseCase.execute(dto);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Resource getById(@PathVariable Long id) {
    return this.getResourceByIdUseCase.execute(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Page<Resource> getAll(@ParameterObject Pageable pageable) {
    return this.getAllResourcesUseCase.execute(pageable);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Resource update(@PathVariable Long id, @RequestBody @Valid UpdateResourceDTO dto) {
    return this.updateResourceUseCase.execute(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long id) {
    this.deleteResourceUseCase.deleteResource(id);
  }
}
