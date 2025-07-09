package br.com.brenno.reservation_management.domain.exceptions.Resource;

public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException(String message) {
    super(message);
  }
}
