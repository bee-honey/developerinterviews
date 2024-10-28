package com.honeybee.developerinterviews.developerinterviews.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {
    private final Long userId;
    private final String jwtToken;
}
