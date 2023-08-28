package com.example.hexagonal.infrastructure.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Component
@AllArgsConstructor
@Slf4j
public class Translator {
    private MessageSource messageSource;

    public String translate(String messageCode) {
        log.debug("1." + messageCode);
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public String translate(String messageCode, Object... args) {
        log.debug("2." + messageCode);
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }
}
