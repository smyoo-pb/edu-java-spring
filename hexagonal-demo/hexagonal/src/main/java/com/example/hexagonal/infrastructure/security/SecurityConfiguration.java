package com.example.hexagonal.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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
						.userService(userService)));
		http.headers(headers -> headers.frameOptions(opt -> opt.disable()));
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
