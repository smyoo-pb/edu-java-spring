package com.example.hexagonal.users.application.port.out;

import com.example.hexagonal.common.TranslatePort;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface UserTranslatePort extends TranslatePort {
    @Override
    public String translate(String messageCode);

    @Override
    public String translate(String messageCode, Object... args);
}
