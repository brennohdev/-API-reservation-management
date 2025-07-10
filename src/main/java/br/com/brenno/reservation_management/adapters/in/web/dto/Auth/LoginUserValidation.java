package br.com.brenno.reservation_management.adapters.in.web.dto.Auth;

import jakarta.validation.constraints.NotBlank;

public record LoginUserValidation(
    @NotBlank(message = "Email cannot be blank.")
    String email,

    @NotBlank(message = "Password cannot be blank.")
    String password
) {
}

