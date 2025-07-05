package br.com.brenno.reservation_management.domain.exceptions.Resource;

public class ResourceAlreadyExistsException extends RuntimeException {

  public ResourceAlreadyExistsException(String message) {
    super(message);
  }
}
