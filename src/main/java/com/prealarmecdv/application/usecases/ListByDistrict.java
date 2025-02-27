package com.prealarmecdv.application.usecases;
import com.prealarmecdv.application.repository.LeiturasRepository;
import com.prealarmecdv.application.response.ResponseHTTP;
import com.prealarmecdv.domain.Enums.Distritos;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Success.GenericSuccess;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.domain.exceptions.InternalServerError;
import com.prealarmecdv.domain.factories.DistritosFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListByDistrict {
    private LeiturasRepository leiturasRepository;

    public ListByDistrict(LeiturasRepository leiturasRepository) {
        this.leiturasRepository = leiturasRepository;
    }
    public Response execute(final String distrito, LocalDateTime dataInicio, LocalDateTime dataFim){
        try {
            if (dataInicio == null) {
                dataInicio = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            }
            if(dataFim == null) dataFim = LocalDateTime.now();
            Distritos distritos = DistritosFactory.getDistrito(distrito);
            List<Leituras> leituras = this.leiturasRepository.findByDistrict(distritos.getInicio(), distritos.getFim(), dataInicio, dataFim);
            return ResponseHTTP.success(new GenericSuccess("Leituras"), leituras);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHTTP.error(new InternalServerError());
        }
    }
}
