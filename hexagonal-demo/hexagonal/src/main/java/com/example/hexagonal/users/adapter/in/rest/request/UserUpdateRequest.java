package com.example.hexagonal.users.adapter.in.rest.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Getter
@ToString
@NoArgsConstructor
public class UserUpdateRequest {
    @NotEmpty
    public String name;
}
