package com.example.billiardclubapi.enumiration;

public enum NumberOfPockets {
    ZERO(0),
    SIX(6);

    private final int value;

    NumberOfPockets(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
