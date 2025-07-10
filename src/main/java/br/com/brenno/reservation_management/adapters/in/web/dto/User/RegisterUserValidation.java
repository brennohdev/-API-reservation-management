package br.com.brenno.reservation_management.adapters.in.web.dto.User;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RegisterUserValidation {
  @Email(message = "Invalid email format.")
  @NotBlank(message = "Email cannot be blank.")
  private String email;

  @NotBlank(message = "Password cannot be blank.")
  @Size(min = 8, message = "Password must be at least 8 characters long.")
  private String password;
}
