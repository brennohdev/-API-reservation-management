package br.com.brenno.reservation_management.adapters.controllers.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.CreateResourceDTO;
import br.com.brenno.reservation_management.adapters.in.web.dto.UpdateResourceDTO;
import br.com.brenno.reservation_management.application.useCases.Resource.CreateResourceUseCase;
import br.com.brenno.reservation_management.application.useCases.Resource.GetAllResourcesUseCase;
import br.com.brenno.reservation_management.application.useCases.Resource.GetResourceByIdUseCase;
import br.com.brenno.reservation_management.application.useCases.Resource.UpdateResourceUseCase;
import br.com.brenno.reservation_management.domain.entities.Resource;
import jakarta.validation.Valid;
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

  public ResourceController(
      CreateResourceUseCase createResourceUseCase,
      GetResourceByIdUseCase getResourceByIdUseCase,
      GetAllResourcesUseCase getAllResourcesUseCase,
      UpdateResourceUseCase updateResourceUseCase) {
    this.createResourceUseCase = createResourceUseCase;
    this.getResourceByIdUseCase = getResourceByIdUseCase;
    this.getAllResourcesUseCase = getAllResourcesUseCase;
    this.updateResourceUseCase = updateResourceUseCase;
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
  public Page<Resource> getAll(Pageable pageable) {
    return this.getAllResourcesUseCase.execute(pageable);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Resource update(@PathVariable Long id, @RequestBody @Valid UpdateResourceDTO dto){
    return this.updateResourceUseCase.execute(id, dto);
  }
}
