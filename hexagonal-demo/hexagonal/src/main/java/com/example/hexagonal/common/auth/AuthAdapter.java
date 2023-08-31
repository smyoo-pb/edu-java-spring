package com.example.hexagonal.common.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.hexagonal.common.auth.port.AuthPort;

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

    private final SecurityContextHolder securityContextHolder;

    @Override
    public Long getId() {
        securityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Long getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

    @Override
    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    @Override
    public String getApp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApp'");
    }

    @Override
    public String getProvider() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProvider'");
    }

}
