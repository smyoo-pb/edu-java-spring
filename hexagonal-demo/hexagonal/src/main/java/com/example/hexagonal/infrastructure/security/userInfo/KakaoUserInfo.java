package com.example.hexagonal.infrastructure.security.userInfo;

import java.util.Map;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public class KakaoUserInfo implements OAuth2UserInfo {
    private String id;
    private OAuthAttributes kakaoAccount;

    public KakaoUserInfo(OAuthAttributes attributes, String id) {
        this.kakaoAccount = attributes;
        this.id = id;
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return kakaoAccount.getEmail();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSnsId() {
        return id;
    }
}
