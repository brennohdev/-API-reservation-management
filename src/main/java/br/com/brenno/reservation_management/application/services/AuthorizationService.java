package br.com.brenno.reservation_management.application.services;

import br.com.brenno.reservation_management.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    return userRepository.findByEmail(username)
        .orElseThrow(() -> new RuntimeException("User not found with email: " + username));
  }
}
