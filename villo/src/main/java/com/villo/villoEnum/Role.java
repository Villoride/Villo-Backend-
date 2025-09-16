package com.villo.villoEnum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    CUSTOMER,
    DRIVER,
    ADMIN;

    @JsonCreator
    public static Role fromString(String role) {
        if (role == null) return CUSTOMER;
        switch (role.toLowerCase()) {
            case "driver": return DRIVER;
            case "admin": return ADMIN;
            default: return CUSTOMER;
        }
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}

