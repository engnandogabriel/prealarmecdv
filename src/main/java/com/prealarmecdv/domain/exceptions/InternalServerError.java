package com.prealarmecdv.domain.exceptions;
import com.prealarmecdv.domain.Response.ErrorResponse;
import com.prealarmecdv.domain.Response.Status;

public class InternalServerError extends ErrorResponse {
    public InternalServerError() {
        super("Erro desconhecido", Status.INTERNALSERVERERROR.getCode(), Status.INTERNALSERVERERROR.name());
    }
}
