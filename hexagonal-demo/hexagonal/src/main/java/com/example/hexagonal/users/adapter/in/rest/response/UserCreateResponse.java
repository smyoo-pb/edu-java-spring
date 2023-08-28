package com.example.hexagonal.users.adapter.in.rest.response;

import com.example.hexagonal.users.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class UserCreateResponse {
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String email;

    public static UserCreateResponse fromDomain(User user) {
        return new UserCreateResponse(
                user.getId(),
                user.getName(),
                user.getEmail());
    }
}