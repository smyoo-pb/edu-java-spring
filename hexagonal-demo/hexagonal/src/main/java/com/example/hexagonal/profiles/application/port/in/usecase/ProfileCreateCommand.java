package com.example.hexagonal.profiles.application.port.in.usecase;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Value
@Builder
public class ProfileCreateCommand {
    private String name;
    private String email;
    private LocalDate birth;
    private String gender;
    private String nickname;
}
