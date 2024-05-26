package ch.zhaw.it.cadprototyp;

import java.util.Optional;

public enum MeasurementUnit {

    MILLIMETER,
    CENTIMETER,
    METER;

    public static Optional<MeasurementUnit> parseUnit(String stringUnit) {
        for (MeasurementUnit u : MeasurementUnit.values()) {
            if (u.name().equals(stringUnit)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
}
