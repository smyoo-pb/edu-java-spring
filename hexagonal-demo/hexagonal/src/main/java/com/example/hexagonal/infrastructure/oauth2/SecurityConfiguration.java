package com.example.hexagonal.infrastructure.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.hexagonal.infrastructure.oauth2.handler.OAuth2FailureHandler;
import com.example.hexagonal.infrastructure.oauth2.handler.OAuth2SuccessHandler;

import lombok.RequiredArgsConstructor;

/**
 * Spring Security Configuration
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	private final PrincipalUserService userService;
	private final OAuth2SuccessHandler successHandler;
	private final OAuth2FailureHandler failureHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
				.anyRequest().permitAll());
		http.formLogin(form -> form.disable());
		http.oauth2Login(oauth2Login -> oauth2Login
				.loginPage("/v1/auth/login")
				.authorizationEndpoint(authorization -> authorization
						.baseUri("/oauth2/authorization"))
				.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
						.userService(userService))
				.redirectionEndpoint(redirect -> redirect
						.baseUri("/oauth2/callback/**"))
				.successHandler(successHandler)
				.failureHandler(failureHandler));
		http.headers(headers -> headers.frameOptions(opt -> opt.disable()));
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
