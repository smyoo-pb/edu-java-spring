package com.example.hexagonal.profiles.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Profile {
    private Long id;

    private Long userId;

    private String name;

    private int birth;

    private String gender;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void update(
            String name,
            int birth,
            String gender,
            String email) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
    }
}
