package com.example.hexagonal.infrastructure.security.userInfo;

import java.util.Map;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public interface OAuth2UserInfo {
    String getSnsId();

    OAuth2Provider getProvider();

    String getEmail();

    String getName();

    String getApp();

    Map<String, Object> getAttributes();
}
