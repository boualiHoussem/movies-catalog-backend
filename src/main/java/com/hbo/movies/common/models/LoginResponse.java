package com.hbo.movies.common.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Data
public class LoginResponse {

    private final String token;
    private UserLoginModel user = new UserLoginModel();

    public LoginResponse(String token) {
        this.token = token;
    }

    @Getter
    @Setter
    public static class UserLoginModel {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
    }
}
