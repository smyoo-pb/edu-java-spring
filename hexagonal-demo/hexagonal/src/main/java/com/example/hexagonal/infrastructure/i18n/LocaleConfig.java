package com.example.hexagonal.infrastructure.i18n;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * Locale Configuration
 * - get locale from Accept-Language header
 * - default KOREA
 * 
 * @author miniyus
 * @date 2023/08/28
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer {
    /**
     * Creates and returns a LocaleResolver bean.
     *
     * @return the LocaleResolver bean
     */
    @Bean
    public LocaleResolver localeResolver() {
        var localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
