package com.example.esd_task1.dto;

import jakarta.validation.constraints.NotNull;

public record LoginResponse(
        @NotNull
        Boolean authenticated,
        String token
) {
}
