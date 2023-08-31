package com.example.hexagonal.profiles.pets.domain;

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
public class PetProfile {
    private Long id;
    private Long userId;
    private String name;
    private String species;
    private String breeds;
    private LocalDate birth;
    private String gender;
    private float weight;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public void update() {

    }
}
