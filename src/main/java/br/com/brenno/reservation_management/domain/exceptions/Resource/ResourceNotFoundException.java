package br.com.brenno.reservation_management.domain.exceptions.Resource;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
