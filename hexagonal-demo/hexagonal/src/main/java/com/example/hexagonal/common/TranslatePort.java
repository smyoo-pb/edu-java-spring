package com.example.hexagonal.common;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface TranslatePort {
    public String translate(String messageCode);

    public String translate(String messageCode, Object... args);
}
