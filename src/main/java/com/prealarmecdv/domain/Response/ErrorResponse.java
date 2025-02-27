package com.prealarmecdv.domain.Response;

public abstract class ErrorResponse extends Exception{
    public String message;
    public int status;
    public String type;

    public ErrorResponse(final String message, final int status, final String type) {
        this.message = message;
        this.status = status;
        this.type = type;
    }
}
