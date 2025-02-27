package com.prealarmecdv.application.response;
import com.prealarmecdv.domain.Response.ErrorResponse;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Response.SuccessResponse;

public class ResponseHTTP extends Response {

    private String message;
    private String type;
    private int status;
    private Object body;

    private ResponseHTTP(final String message, final String type, final int status, final Object body) {
        super(message, type, status, body);
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

    public static ResponseHTTP success(SuccessResponse suceess, Object body) {
        return new ResponseHTTP(suceess.message, suceess.status.name(), suceess.status.getCode(), body);
    }

    public static ResponseHTTP error(ErrorResponse error) {
        return new ResponseHTTP(error.message, error.type, error.status, null);
    }

}
