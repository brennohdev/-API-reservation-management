package br.com.brenno.reservation_management.application.useCases.User;

import br.com.brenno.reservation_management.adapters.in.web.dto.Auth.LoginResponse;
import br.com.brenno.reservation_management.adapters.in.web.dto.Auth.LoginUserValidation;
import br.com.brenno.reservation_management.adapters.in.web.dto.User.UserResponse;
import br.com.brenno.reservation_management.config.security.TokenService;
import br.com.brenno.reservation_management.domain.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginUserUseCase {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  public LoginUserUseCase(AuthenticationManager authenticationManager, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  public LoginResponse execute(LoginUserValidation dto) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

    var authentication = authenticationManager.authenticate(usernamePassword);

    var user = (User) authentication.getPrincipal();

    var token = tokenService.generateToken(user);

    return new LoginResponse(token, new UserResponse(user));
  }
}
