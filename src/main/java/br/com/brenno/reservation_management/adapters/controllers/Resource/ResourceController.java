package br.com.brenno.reservation_management.adapters.controllers.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.CreateResourceDTO;
import br.com.brenno.reservation_management.application.useCases.Resource.CreateResourceUseCase;
import br.com.brenno.reservation_management.application.useCases.Resource.GetResourceByIdUseCase;
import br.com.brenno.reservation_management.domain.entities.Resource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
  private final CreateResourceUseCase createResourceUseCase;
  private final GetResourceByIdUseCase getResourceByIdUseCase;

  public ResourceController(CreateResourceUseCase createResourceUseCase, GetResourceByIdUseCase getResourceByIdUseCase) {
    this.createResourceUseCase = createResourceUseCase;
    this.getResourceByIdUseCase = getResourceByIdUseCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Resource create(@RequestBody @Valid CreateResourceDTO dto) {
    Resource createdResource = this.createResourceUseCase.execute(dto);

    return createdResource;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Resource getById(@PathVariable Long id) {
    return this.getResourceByIdUseCase.execute(id);
  }

}
