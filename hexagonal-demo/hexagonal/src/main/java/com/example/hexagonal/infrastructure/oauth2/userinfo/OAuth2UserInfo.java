package com.example.hexagonal.infrastructure.oauth2.userinfo;

import java.util.Map;

import com.example.hexagonal.infrastructure.oauth2.OAuth2Provider;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public interface OAuth2UserInfo {
    String getSnsId();

    String getApp();

    OAuth2Provider getProvider();

    String getEmail();

    String getName();

    Map<String, Object> getAttributes();
}
