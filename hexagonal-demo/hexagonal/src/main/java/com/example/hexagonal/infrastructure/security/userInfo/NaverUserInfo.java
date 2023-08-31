package com.example.hexagonal.infrastructure.security.userInfo;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
@Builder
@Getter
@RequiredArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo {
    private final String snsId;
    private final String email;
    private final String app;
    private final String name;
    private final Map<String, Object> attributes;

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.NAVER;
    }
}
