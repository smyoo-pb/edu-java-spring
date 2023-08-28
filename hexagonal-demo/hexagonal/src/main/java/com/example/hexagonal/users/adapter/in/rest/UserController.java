package com.example.hexagonal.users.adapter.in.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpStatus;
import com.example.hexagonal.users.adapter.in.rest.request.UserCreateRequest;
import com.example.hexagonal.users.adapter.in.rest.request.UserUpdateRequest;
import com.example.hexagonal.users.adapter.in.rest.response.UserCreateResponse;
import com.example.hexagonal.users.adapter.in.rest.response.UserResponse;
import com.example.hexagonal.users.application.port.in.UserCreateCommand;
import com.example.hexagonal.users.application.port.in.UserCreateUseCase;
import com.example.hexagonal.users.application.port.in.UserDeleteUseCase;
import com.example.hexagonal.users.application.port.in.UserFindAllQuery;
import com.example.hexagonal.users.application.port.in.UserFindQuery;
import com.example.hexagonal.users.application.port.in.UserUpdateCommand;
import com.example.hexagonal.users.application.port.in.UserUpdateUseCase;
import com.example.hexagonal.users.domain.User;
import jakarta.validation.Valid;
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
    private final UserFindAllQuery userFindAllQuery;
    private final UserFindQuery userFindQuery;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserDeleteUseCase userDeleteUseCase;

    @PostMapping
    public ResponseEntity<UserCreateResponse> create(
            @Valid @RequestBody UserCreateRequest userCreate,
            UriComponentsBuilder uriComponentsBuilder) {

        UserCreateCommand command = UserCreateCommand.builder()
                .name(userCreate.getName())
                .email(userCreate.getEmail()).build();

        User response = userCreateUseCase.create(command);
        URI uri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(UserCreateResponse.fromDomain(response));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(UserResponse.fromDomain(userFindAllQuery.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(
            @PathVariable Long id) {
        return ResponseEntity.ok().body(UserResponse.fromDomain(userFindQuery.findById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest userUpdate) {
        var command = UserUpdateCommand.builder()
                .name(userUpdate.getName())
                .build();
        User user = userUpdateUseCase.update(command);
        return ResponseEntity.ok().body(UserResponse.fromDomain(user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userDeleteUseCase.deleteById(id);
    }
}
