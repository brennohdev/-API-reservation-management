package br.com.brenno.reservation_management.config.security;

import br.com.brenno.reservation_management.domain.entities.User;
import br.com.brenno.reservation_management.infrastructure.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    var token = this.recoverToken(request);


    if (token != null) {

      var email = tokenService.validateToken(token);

      User user = userRepository.findByEmail(email)
          .orElseThrow(() -> new RuntimeException("User not found"));

      var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  private String recoverToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");
    if (authHeader == null) {
      return null;
    }
    return authHeader.replace("Bearer ", "");
  }
}
