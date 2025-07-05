package br.com.brenno.reservation_management.adapters.in.web.exceptions;

import java.time.ZonedDateTime;

public record ApiErrorResponse(ZonedDateTime timestamp, int status, String message) {
}