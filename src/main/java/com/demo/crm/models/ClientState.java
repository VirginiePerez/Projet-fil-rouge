package com.demo.crm.models;

public enum ClientState {
    ACTIVE(0),
    INACTIVE(1);

    private final int value;

    ClientState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}