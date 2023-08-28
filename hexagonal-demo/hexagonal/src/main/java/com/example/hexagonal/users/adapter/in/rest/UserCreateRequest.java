package com.example.hexagonal.users.adapter.in.rest;

import com.example.hexagonal.users.domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @Getter
    @NotEmpty
    private String name;

    @Getter
    @NotEmpty
    @Email
    private String email;

    public User toDomain() {
        return new User(null, name, email);
    }
}