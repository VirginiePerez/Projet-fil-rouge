package com.demo.crm.models;

public enum OrderState {
    CANCELED(1),
    OPTION(0),
    CONFIRMED(2);

    private final int value;

    OrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}