package br.com.brenno.reservation_management.adapters.controllers.Auth;

import br.com.brenno.reservation_management.adapters.in.web.dto.Auth.LoginResponse;
import br.com.brenno.reservation_management.adapters.in.web.dto.Auth.LoginUserValidation;
import br.com.brenno.reservation_management.application.useCases.User.LoginUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final LoginUserUseCase loginUserUseCase;

  public AuthController(LoginUserUseCase loginUserUseCase) {
    this.loginUserUseCase = loginUserUseCase;
  }

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  public LoginResponse login(@RequestBody @Valid LoginUserValidation dto) {
    return this.loginUserUseCase.execute(dto);
  }
}
