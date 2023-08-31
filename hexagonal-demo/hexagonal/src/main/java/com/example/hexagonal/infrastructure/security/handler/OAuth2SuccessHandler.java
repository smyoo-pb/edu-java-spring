package com.example.hexagonal.infrastructure.security.handler;

import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.example.hexagonal.infrastructure.security.IssueTokenResponse;
import com.example.hexagonal.infrastructure.security.JwtService;
import com.example.hexagonal.infrastructure.security.PrincipalUserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        log.debug("OAuth2 Login 성공!");

        if (response.isCommitted()) {
            log.debug("Response has already been committed.");
            return;
        }

        try {
            PrincipalUserInfo oAuth2User = (PrincipalUserInfo) authentication.getPrincipal();

            issueToken(response, oAuth2User);
        } catch (Exception e) {
            throw e;
        }
    }

    private void issueToken(HttpServletResponse response, PrincipalUserInfo oAuth2User) throws IOException {
        IssueTokenResponse issueTokenResponse = jwtService.issueToken(oAuth2User);
        String jsonBody = objectMapper.writeValueAsString(issueTokenResponse);
        response.getWriter().write(jsonBody);
    }
}