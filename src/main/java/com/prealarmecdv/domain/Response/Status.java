package com.prealarmecdv.domain.Response;

public enum Status {
    SUCCESS(200),
    CREATED(201),
    CONFLICT(409),
    INTERNALSERVERERROR(500),
    NOTFOUND(404),
    BADREQUEST(400);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}