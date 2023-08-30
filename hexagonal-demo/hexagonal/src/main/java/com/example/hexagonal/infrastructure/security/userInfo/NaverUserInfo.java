package com.example.hexagonal.infrastructure.security.userInfo;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public class NaverUserInfo implements OAuth2UserInfo {
    private final OAuthAttributes attributes;

    public NaverUserInfo(OAuthAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getSnsId() {
        return attributes.getId();
    }

    @Override
    public String getProvider() {
        return "naver";
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
