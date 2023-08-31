package com.example.hexagonal.infrastructure.security.userInfo;

import java.util.Map;
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
@AllArgsConstructor
@Getter
public class KakaoUserInfo implements OAuth2UserInfo {
    private final String email;
    private final String name;
    private final String snsId;
    private final String app;
    private final Map<String, Object> attributes;

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.KAKAO;
    }
}
