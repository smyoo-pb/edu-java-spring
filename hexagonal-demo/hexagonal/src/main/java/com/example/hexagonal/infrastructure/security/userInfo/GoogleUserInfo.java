package com.example.hexagonal.infrastructure.security.userInfo;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public class GoogleUserInfo implements OAuth2UserInfo {
    private final OAuthAttributes attributes;

    public GoogleUserInfo(OAuthAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getSnsId() {
        return attributes.getId();
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getEmail() {
        return attributes.getEmail();
    }

    @Override
    public String getName() {
        return attributes.getName();
    }

}
