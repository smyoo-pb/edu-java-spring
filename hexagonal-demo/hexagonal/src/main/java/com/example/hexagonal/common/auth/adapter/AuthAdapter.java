package com.example.hexagonal.common.auth.adapter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.hexagonal.common.auth.port.AuthPort;
import com.example.hexagonal.common.error.AuthErrorCode;
import com.example.hexagonal.common.error.AuthErrorException;
import com.example.hexagonal.infrastructure.oauth2.PrincipalUserInfo;

import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
@Component
@RequiredArgsConstructor
public class AuthAdapter implements AuthPort {

    private PrincipalUserInfo user;

    private PrincipalUserInfo getUser() {
        if (user == null) {
            var principal = (PrincipalUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal == null) {
                throw new AuthErrorException("", AuthErrorCode.ACCESS_DENINED);
            }
            user = principal;
        }

        return user;
    }

    @Override
    public Long getId() {
        return getUser().getUserEntity().getId();
    }

    @Override
    public String getName() {
        return getUser().getUserEntity().getName();
    }

    @Override
    public String getEmail() {
        return getUser().getUsername();
    }

    @Override
    public String getApp() {
        return getUser().getUserEntity().getApp();
    }

    @Override
    public String getProvider() {
        return getUser().getUserEntity().getProvider();
    }

}
