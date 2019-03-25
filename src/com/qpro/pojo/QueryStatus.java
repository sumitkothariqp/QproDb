package com.qpro.pojo;

import java.util.Arrays;

public enum QueryStatus {

    VALIDATION_FAIL(0),
    PASS(1);

    private int id;

    public int getId() {
        return id;
    }

    QueryStatus(int id) {
        this.id = id;
    }

    public static QueryStatus getById(int id) {
        return Arrays.stream(QueryStatus.values()).filter(i-> i.getId() == id).findFirst().orElse(null);
    }
}
