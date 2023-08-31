package com.example.hexagonal.infrastructure.security;

import com.example.hexagonal.infrastructure.security.userInfo.OAuth2Provider;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
@Data
@AllArgsConstructor
public class IssueTokenResponse {
    private String snsId;
    private OAuth2Provider Provider;
    private String accessToken;
    private Long expiresIn;
    private String refreshToken;
}
