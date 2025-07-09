package br.com.brenno.reservation_management.adapters.in.web.dto.Resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateResourceDTO(
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message = "Name must not exceed 100 characters")
    String name,

    String description,

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 0, message = "Capacity must be at least 0")
    Integer capacity
) {}
