package br.com.brenno.reservation_management.adapters.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public class CreateResourceDTO {
  @NotBlank(message = "Name is required")
  @Size(min= 1, max = 100, message = "Name must not exceed 100 characters")
  private String name;

  private String description;

  @NotNull(message = "Capacity cannot be null")
  @Min(value = 0, message = "Capacity must be at least 1")
  private int capacity;


}
