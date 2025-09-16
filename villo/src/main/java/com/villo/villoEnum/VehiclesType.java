package com.villo.villoEnum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VehiclesType {
    CAR,
    BIKE,
    AUTO,
    BUS,
    TRUCK,
    VAN;

    @JsonCreator
    public static VehiclesType fromString(String type) {
        if (type == null) return CAR;
        switch (type.toLowerCase()) {
            case "bike": return BIKE;
            case "auto": return AUTO;
            case "bus": return BUS;
            case "truck": return TRUCK;
            case "van": return VAN;
            default: return CAR;
        }
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
