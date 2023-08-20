package com.precisionbio.springboot.todo.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userdetails1 = createNewUser("smyoo", "dummy");
        UserDetails userdetails2 = createNewUser("smyoo-pb", "dummy");
        return new InMemoryUserDetailsManager(userdetails1, userdetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userdetails = User.builder()
                .passwordEncoder(
                        input -> passwordEncoder().encode(input))
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userdetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf(c -> c.disable());
        http.headers(header -> header.frameOptions(fo -> fo.disable()));
        return http.build();
    }
}
