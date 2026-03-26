package com.example.microservicespro.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {
    final private int code;
    final private String message;
    final private LocalDateTime timestamp= LocalDateTime.now();
}
