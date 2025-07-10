package br.com.brenno.reservation_management.adapters.controllers.User;

import br.com.brenno.reservation_management.adapters.in.web.dto.User.RegisterUserValidation;
import br.com.brenno.reservation_management.application.useCases.User.RegisterUserUseCase;
import br.com.brenno.reservation_management.domain.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final RegisterUserUseCase registerUserUseCase;

  public UserController(RegisterUserUseCase registerUserUseCase) {
    this.registerUserUseCase = registerUserUseCase;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody @Valid RegisterUserValidation dto) {
    return this.registerUserUseCase.execute(dto);
  }
}
