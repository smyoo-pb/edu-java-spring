package com.example.hexagonal.users.adapter.in.rest;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.hexagonal.users.application.port.in.UserCreateUseCase;
import com.example.hexagonal.users.domain.User;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserCreateUseCase userCreateUseCase;

    @PostMapping("")
    public ResponseEntity<UserCreateResponse> create(
            @Valid @RequestBody UserCreateRequest userCreate,
            UriComponentsBuilder uriComponentsBuilder) {
        User response = userCreateUseCase.create(userCreate.toDomain());
        URI uri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(UserCreateResponse.fromDomain(response));
    }
}
