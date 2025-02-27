package com.prealarmecdv.application.usecases;
import com.prealarmecdv.application.repository.LeiturasRepository;
import com.prealarmecdv.application.response.ResponseHTTP;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Success.GenericSuccess;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.domain.exceptions.InternalServerError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllLeituras {
    private LeiturasRepository leiturasRepository;

    public ListAllLeituras(LeiturasRepository leiturasRepository) {
        this.leiturasRepository = leiturasRepository;
    }
    public Response execute(){
        try {
            List<Leituras> leituras = this.leiturasRepository.getAll();
            return ResponseHTTP.success(new GenericSuccess(""), leituras);
        }catch (Exception e){
            return ResponseHTTP.error(new InternalServerError());
        }
    }
}
