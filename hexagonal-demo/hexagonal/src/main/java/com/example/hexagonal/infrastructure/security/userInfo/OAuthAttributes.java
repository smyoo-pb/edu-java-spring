package com.example.hexagonal.infrastructure.security.userInfo;

import java.util.Map;

import com.example.hexagonal.infrastructure.security.exception.NotSupportProviderException;

import lombok.Builder;
import lombok.Getter;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
@Getter
@Builder
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String id;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String provider;

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
            Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            var naver = ofNaver("id", attributes);
            naver.provider = registrationId;
            return naver;
        } else if ("kakao".equals(registrationId)) {
            var kakao = ofKakao("id", attributes);
            kakao.provider = registrationId;
            return kakao;
        }

        var google = ofGoogle(userNameAttributeName, attributes);
        google.provider = registrationId;
        return google;
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .id((String) attributes.get("sub"))
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return OAuthAttributes.builder()
                .id((String) response.get("id"))
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();

    }

    @SuppressWarnings("unchecked")
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
        return OAuthAttributes.builder()
                .id((String) kakaoAccount.get("id"))
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .attributes(kakaoAccount)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public OAuth2UserInfo toUserInfo() {
        switch (this.provider) {
            case "google":
                return new GoogleUserInfo(this);
            case "kakao":
                return new KakaoUserInfo(this, this.id);
            case "naver":
                return new NaverUserInfo(this);
            default:
                throw new NotSupportProviderException(this.provider);
        }
    }
}
