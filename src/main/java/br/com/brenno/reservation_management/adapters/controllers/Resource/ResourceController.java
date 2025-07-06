package br.com.brenno.reservation_management.adapters.controllers.Resource;

import br.com.brenno.reservation_management.adapters.in.web.dto.CreateResourceDTO;
import br.com.brenno.reservation_management.application.useCases.Resource.CreateResourceUseCase;
import br.com.brenno.reservation_management.domain.entities.Resource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources/create")
public class ResourceController {
  private final CreateResourceUseCase createResourceUseCase;

  public ResourceController(CreateResourceUseCase createResourceUseCase) {
    this.createResourceUseCase = createResourceUseCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Resource create(@RequestBody @Valid CreateResourceDTO dto) {
    Resource createdResource = this.createResourceUseCase.execute(dto);

    return createdResource;
  }


}
