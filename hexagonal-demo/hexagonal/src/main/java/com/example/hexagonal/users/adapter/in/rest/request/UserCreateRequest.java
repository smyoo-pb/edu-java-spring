package com.example.hexagonal.users.adapter.in.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Getter
@ToString
@NoArgsConstructor
public class UserCreateRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
}