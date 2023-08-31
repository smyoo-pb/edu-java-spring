package com.example.hexagonal.profiles.domain;

import java.time.LocalDate;
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
    protected Long id;
    protected Long userId;
    protected String name;
    protected LocalDate birth;
    protected String gender;

    private String email;
    private String nickname;

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected LocalDateTime deletedAt;

    public void update(
            String name,
            LocalDate birth,
            String gender,
            String email,
            String nickname) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.nickname = nickname;
    }
}
