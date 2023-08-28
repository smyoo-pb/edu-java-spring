package com.example.hexagonal.users.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@AllArgsConstructor
public class User {
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String email;
}
