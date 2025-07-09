package br.com.brenno.reservation_management.adapters.in.web.exceptions;

import br.com.brenno.reservation_management.domain.exceptions.Resource.EmailAlreadyExistsException;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceAlreadyExistsException;
import br.com.brenno.reservation_management.domain.exceptions.Resource.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiErrorResponse handleValidationExceptions(MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();

    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    String detailedMessage = "Validation failed for one or more fields: " + errors;

    return new ApiErrorResponse(
        ZonedDateTime.now(),
        HttpStatus.BAD_REQUEST.value(),
        detailedMessage
    );
  }

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

  @ExceptionHandler(EmailAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ApiErrorResponse handleEmailAlreadyExists(EmailAlreadyExistsException exception) {
    return new ApiErrorResponse(
        ZonedDateTime.now(),
        HttpStatus.CONFLICT.value(),
        exception.getMessage()
    );
  }

}
