package com.example.hexagonal.common.constant;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
public enum AppType {
    HUMAN("human"),
    ANIMAL("animal"),
    UNDEFINED(null);

    private final String value;

    AppType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
