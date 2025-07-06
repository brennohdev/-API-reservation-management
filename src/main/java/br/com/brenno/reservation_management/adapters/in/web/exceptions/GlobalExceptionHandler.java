package br.com.brenno.reservation_management.adapters.in.web.exceptions;

import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceAlreadyExistsException;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ApiErrorResponse handleResourceAlreadyExists(ResourceAlreadyExistsException exception) {
    return new ApiErrorResponse(
        ZonedDateTime.now(),
        HttpStatus.CONFLICT.value(),
        exception.getMessage()
    );
  }


  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiErrorResponse handleResourceNotFound(ResourceNotFoundException exception) {
    return new ApiErrorResponse(
        ZonedDateTime.now(),
        HttpStatus.NOT_FOUND.value(),
        exception.getMessage()
    );
  }
}
