package com.example.hexagonal.infrastructure.oauth2.handler;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import com.example.hexagonal.common.error.AuthErrorCode;
import com.example.hexagonal.infrastructure.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/09/01
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class OAuth2AccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException exception) throws IOException, ServletException {
        log.debug("Access Denied: {}", exception.getMessage());

        AuthErrorCode code = AuthErrorCode.ACCESS_DENINED;
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                code.name(),
                exception.getMessage(),
                null);
        String errorJsonBody = objectMapper.writeValueAsString(errorResponse);

        response.setHeader("Content-Type", "application/json");
        response.setStatus(code.getStatusCode());
        response.getWriter().write(errorJsonBody);
    }

}
