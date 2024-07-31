package com.lendo.api.model.security;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String role;
}
