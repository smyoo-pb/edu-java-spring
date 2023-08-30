package com.example.hexagonal.infrastructure.security.userInfo;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public interface OAuth2UserInfo {
    String getSnsId();

    String getProvider();

    String getEmail();

    String getName();
}
