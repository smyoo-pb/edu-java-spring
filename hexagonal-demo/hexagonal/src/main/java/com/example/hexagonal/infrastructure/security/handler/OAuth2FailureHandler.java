package com.example.hexagonal.infrastructure.security.handler;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.example.hexagonal.common.error.AuthErrorCode;
import com.example.hexagonal.infrastructure.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import jakarta.servlet.ServletException;
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
@Component
@Slf4j
@RequiredArgsConstructor
public class OAuth2FailureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        log.error("Failure oauth login: {}", exception.getMessage());

        AuthErrorCode code = AuthErrorCode.INVALID_CLIENT;
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                code.name(),
                exception.getMessage(),
                null);
        String errorJsonBody = objectMapper.writeValueAsString(errorResponse);

        response.setStatus(code.getStatusCode());
        response.getWriter().write(errorJsonBody);

    }
}
