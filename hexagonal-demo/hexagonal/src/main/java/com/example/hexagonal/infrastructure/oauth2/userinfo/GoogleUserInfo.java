package com.example.hexagonal.infrastructure.oauth2.userinfo;

import java.util.Map;

import com.example.hexagonal.infrastructure.oauth2.OAuth2Provider;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
@Builder
@Getter
@AllArgsConstructor
public class GoogleUserInfo implements OAuth2UserInfo {

    private final String snsId;

    @Nullable
    private final String app;

    private final String email;

    private final String name;

    private final Map<String, Object> attributes;

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.GOOGLE;
    }
}
