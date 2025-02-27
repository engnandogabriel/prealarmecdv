package com.prealarmecdv.domain.Response;

public abstract class SuccessResponse {
    public String message;
    public Status status;

    public SuccessResponse(final String message, final Status status) {
        this.message = message;
        this.status = status;
    }
}
