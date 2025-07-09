package br.com.brenno.reservation_management.application.useCases.User;

import br.com.brenno.reservation_management.adapters.in.web.dto.User.RegisterUserDTO;
import br.com.brenno.reservation_management.domain.entities.User;
import br.com.brenno.reservation_management.domain.enums.User.UserRole;
import br.com.brenno.reservation_management.domain.exceptions.Resource.EmailAlreadyExistsException;
import br.com.brenno.reservation_management.infrastructure.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserUseCase {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User execute(RegisterUserDTO dto) {
    Optional<User> existingUser = userRepository.findByEmail(dto.getEmail());

    if (existingUser.isPresent()) {
      throw new EmailAlreadyExistsException(
          "A resource with the name '" + dto.getEmail() + "' already exists."
      );
    }

    String hashedPassword = passwordEncoder.encode(dto.getPassword());

    User newUser = new User(
        dto.getEmail(),
        hashedPassword,
        UserRole.USER
    );

    return userRepository.save(newUser);
  }
}
