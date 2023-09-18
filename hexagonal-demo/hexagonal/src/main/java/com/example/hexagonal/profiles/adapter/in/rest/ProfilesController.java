package com.example.hexagonal.profiles.adapter.in.rest;

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
import com.example.hexagonal.profiles.adapter.in.rest.request.ProfileCreateRequest;
import com.example.hexagonal.profiles.adapter.in.rest.request.ProfileUpdateRequest;
import com.example.hexagonal.profiles.adapter.in.rest.response.ProfileCreateResponse;
import com.example.hexagonal.profiles.adapter.in.rest.response.ProfileResponse;
import com.example.hexagonal.profiles.application.port.in.query.ProfileFindAllQuery;
import com.example.hexagonal.profiles.application.port.in.query.ProfileFindQuery;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileCreateCommand;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileCreateUseCase;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileDeleteUseCase;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileUpdateCommand;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileUpdateUseCase;
import com.example.hexagonal.profiles.domain.Profile;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RestController
@RequestMapping("v1/profiles")
@RequiredArgsConstructor
public class ProfilesController {
    private final ProfileCreateUseCase userCreateUseCase;
    private final ProfileFindAllQuery userFindAllQuery;
    private final ProfileFindQuery userFindQuery;
    private final ProfileUpdateUseCase userUpdateUseCase;
    private final ProfileDeleteUseCase userDeleteUseCase;

    @PostMapping
    public ResponseEntity<ProfileCreateResponse> create(
            @Valid @RequestBody ProfileCreateRequest profileCreate,
            UriComponentsBuilder uriComponentsBuilder) {

        ProfileCreateCommand command = profileCreate.toCommand();

        Profile response = userCreateUseCase.create(command);
        URI uri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(ProfileCreateResponse.fromDomain(response));
    }

    @GetMapping
    public ResponseEntity<List<ProfileResponse>> findAll() {
        return ResponseEntity.ok().body(ProfileResponse.fromDomain(userFindAllQuery.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> findById(
            @PathVariable Long id) {
        return ResponseEntity.ok().body(ProfileResponse.fromDomain(userFindQuery.findById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProfileResponse> updateUser(
            @PathVariable Long id,
            @RequestBody ProfileUpdateRequest userUpdate) {
        var command = ProfileUpdateCommand.builder()
                .name(userUpdate.getName())
                .id(id)
                .build();
        Profile user = userUpdateUseCase.update(command);
        return ResponseEntity.ok().body(ProfileResponse.fromDomain(user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(
            @PathVariable Long id) {
        userDeleteUseCase.deleteById(id);
    }
}
