package com.villo.villoEnum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    USER,
    DRIVER,
    ADMIN;

    @JsonCreator
    public static Role fromString(String role) {
        if (role == null) return USER;
        switch (role.toLowerCase()) {
            case "driver": return DRIVER;
            case "admin": return ADMIN;
            default: return USER;
        }
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}

