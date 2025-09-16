package com.villo.villoEnum;

public enum Status {
    ACTIVE,
    INACTIVE;

    public static Status fromString(String status) {
        if (status == null) return ACTIVE;
        switch (status.toLowerCase()) {
            case "inactive":
                return INACTIVE;
            default:
                return ACTIVE;
        }
    }
}
