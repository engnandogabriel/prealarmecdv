package com.prealarmecdv.application.usecases;

import com.prealarmecdv.application.repository.RemotaRepository;
import com.prealarmecdv.application.response.ResponseHTTP;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Success.GenericSuccess;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.domain.exceptions.InternalServerError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAddress {
    private RemotaRepository remotaRepository;

    public GetAllAddress(RemotaRepository remotaRepository) {
        this.remotaRepository = remotaRepository;
    }
    public Response execute(){
        try {
            List<String> address = this.remotaRepository.getAllAddress();
            return ResponseHTTP.success(new GenericSuccess(""), address);
        }catch (Exception e){
            return ResponseHTTP.error(new InternalServerError());
        }
    }
}
