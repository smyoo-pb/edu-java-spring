package com.example.hexagonal.users.adapter.in.rest.response;

import java.util.List;

import com.example.hexagonal.users.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class UserResponse {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String email;

    public static UserResponse fromDomain(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail());
    }

    public static List<UserResponse> fromDomain(List<User> users) {
        return users.stream().map(UserResponse::fromDomain).toList();
    }
}
