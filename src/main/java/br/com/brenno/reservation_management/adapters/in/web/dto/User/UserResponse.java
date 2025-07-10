package br.com.brenno.reservation_management.adapters.in.web.dto.User;

import br.com.brenno.reservation_management.domain.entities.User;
import br.com.brenno.reservation_management.domain.enums.User.UserRole;

public record UserResponse(Long id, String email, UserRole role) {

  public UserResponse(User user) {
    this(user.getId(), user.getEmail(), user.getRole());
  }
}
