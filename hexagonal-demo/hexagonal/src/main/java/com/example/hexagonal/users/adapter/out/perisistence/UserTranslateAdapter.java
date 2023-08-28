package com.example.hexagonal.users.adapter.out.perisistence;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.i18n.Translator;
import com.example.hexagonal.users.application.port.out.UserTranslatePort;

import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Component
@Slf4j
public class UserTranslateAdapter implements UserTranslatePort {
    private final Translator translator;

    public UserTranslateAdapter(Translator translator) {
        this.translator = translator;
    }

    @Override
    public String translate(String messageCode) {
        log.debug("adp1" + messageCode);
        return translator.translate(messageCode);
    }

    @Override
    public String translate(String messageCode, Object... args) {
        log.debug("adp2" + messageCode);
        return translator.translate(messageCode, args);
    }
}
