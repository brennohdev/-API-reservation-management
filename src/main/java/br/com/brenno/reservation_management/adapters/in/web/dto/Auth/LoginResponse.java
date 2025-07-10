package br.com.brenno.reservation_management.adapters.in.web.dto.Auth;

import br.com.brenno.reservation_management.adapters.in.web.dto.User.UserResponse;

public record LoginResponse(String token, UserResponse user) {
}
