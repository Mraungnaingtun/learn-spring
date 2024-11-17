package com.trainSpringBoot.logant.Enum;

public enum RecordStatus {
    CREATED(1),
    UPDATED(2),
    INSERTD(3),
    DELETED(4);

    private final int value;

    RecordStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RecordStatus fromValue(int value) {
        for (RecordStatus status : RecordStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
