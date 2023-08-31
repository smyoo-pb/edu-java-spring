package com.example.hexagonal.common.constant;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
public enum AppType {
    ADMIN("console"),
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

    public static AppType of(String value) {
        if (value == null) {
            return AppType.UNDEFINED;
        }

        switch (value) {
            case "human":
                return AppType.HUMAN;
            case "animal":
                return AppType.ANIMAL;
            default:
                return AppType.UNDEFINED;
        }
    }
}
