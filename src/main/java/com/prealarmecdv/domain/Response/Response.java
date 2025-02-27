package com.prealarmecdv.domain.Response;

public abstract class Response {
    protected String message;
    protected String type;
    protected int status;
    protected Object body;

    public Response(final String message, final String type, final int status, final Object body) {
        this.message = message;
        this.type = type;
        this.status = status;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public Object getBody() {
        return body;
    }
}
