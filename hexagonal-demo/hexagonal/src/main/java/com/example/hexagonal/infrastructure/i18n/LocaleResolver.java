package com.example.hexagonal.infrastructure.i18n;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Configuration
public class LocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return null == headerLang || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.forLanguageTag(headerLang);
    }
}
