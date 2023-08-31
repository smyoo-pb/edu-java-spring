package com.example.hexagonal.infrastructure.oauth2.userinfo;

import java.util.Map;

import com.example.hexagonal.infrastructure.oauth2.OAuth2Provider;
import com.example.hexagonal.infrastructure.oauth2.exception.NotSupportProviderException;
import com.example.hexagonal.common.constant.AppType;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
@Getter
@Builder
@Slf4j
public class OAuth2Attributes {
    private Map<String, Object> attributes;
    private String id;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String provider;
    private String app;

    public static OAuth2Attributes of(String registrationId, String userNameAttributeName,
            Map<String, Object> attributes) {
        String[] registration = registrationId.split("-");
        String provider = registration[0];
        String app = AppType.UNCHECKED.getValue();

        if (registration.length > 1) {
            app = registration[1];
        }

        if ("naver".equals(provider)) {
            var naver = ofNaver("id", attributes);
            naver.provider = provider;
            naver.app = app;
            return naver;
        } else if ("kakao".equals(provider)) {
            var kakao = ofKakao("id", attributes);
            kakao.provider = provider;
            kakao.app = app;
            return kakao;
        }

        var google = ofGoogle(userNameAttributeName, attributes);
        google.provider = provider;
        google.app = app;
        return google;
    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuth2Attributes.builder()
                .id((String) attributes.get("sub"))
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return OAuth2Attributes.builder()
                .id((String) response.get("id"))
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();

    }

    @SuppressWarnings("unchecked")
    private static OAuth2Attributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
        return OAuth2Attributes.builder()
                .id((String) kakaoAccount.get("id"))
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .attributes(kakaoAccount)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public OAuth2UserInfo toUserInfo() {
        try {
            OAuth2Provider provider = OAuth2Provider.of(this.provider);
            switch (provider) {
                case GOOGLE:
                    return GoogleUserInfo.builder()
                            .app(app)
                            .email(email)
                            .snsId(id)
                            .name(name)
                            .attributes(attributes)
                            .build();
                case KAKAO:
                    return KakaoUserInfo.builder()
                            .app(app)
                            .email(email)
                            .snsId(id)
                            .name(name)
                            .attributes(attributes)
                            .build();
                case NAVER:
                    return NaverUserInfo.builder()
                            .app(app)
                            .email(email)
                            .snsId(id)
                            .name(name)
                            .attributes(attributes)
                            .build();
                default:
                    throw new NotSupportProviderException(this.provider);
            }
        } catch (IllegalArgumentException e) {
            throw new NotSupportProviderException(e.getMessage() + ":" + this.provider);
        }
    }
}
