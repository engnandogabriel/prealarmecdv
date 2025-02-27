package com.prealarmecdv.domain.Success;
import com.prealarmecdv.domain.Response.Status;
import com.prealarmecdv.domain.Response.SuccessResponse;

public class GenericSuccess extends SuccessResponse {
    public GenericSuccess(final String message) {
        super(message, Status.SUCCESS);
    }
}
