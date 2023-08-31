package com.example.hexagonal.infrastructure.security.userInfo;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
public enum OAuth2Provider {
    GOOGLE("google"),
    NAVER("naver"),
    KAKAO("kakao");

    private final String id;

    OAuth2Provider(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static OAuth2Provider of(String registrationId) {
        return OAuth2Provider.valueOf(registrationId);
    }
}
