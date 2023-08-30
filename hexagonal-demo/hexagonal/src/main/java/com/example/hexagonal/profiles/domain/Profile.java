package com.example.hexagonal.profiles.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@AllArgsConstructor
@Getter
public class Profile {
    private Long id;
    private Long userId;
    private String app;
    private String name;
    private String species;
    private String email;
    private LocalDate birth;
    private String gender;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
