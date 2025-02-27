package com.prealarmecdv.application.usecases;

import com.prealarmecdv.application.repository.LeiturasRepository;
import com.prealarmecdv.application.response.ResponseHTTP;
import com.prealarmecdv.domain.Enums.Distritos;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Success.GenericSuccess;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.domain.entities.Remotas;
import com.prealarmecdv.domain.exceptions.InternalServerError;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class ListByAddress {
    LeiturasRepository leiturasRepository;

    public ListByAddress(LeiturasRepository leiturasRepository) {
        this.leiturasRepository = leiturasRepository;
    }

    public Response execute(final String address, LocalDateTime dataInicio, LocalDateTime dataFim){
        try {
            if (dataInicio == null) {
                dataInicio = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            }
            if(dataFim == null) dataFim = LocalDateTime.now();
            List<Leituras> leituras = this.leiturasRepository.findByAddress(address, dataInicio, dataFim);
            Map<String, List<Leituras>> output = leituras.stream()
                    .collect(Collectors.groupingBy(
                            Leituras::getCircuito,
                            TreeMap::new,
                            Collectors.toList()
                    ));
            return ResponseHTTP.success(new GenericSuccess("Leituras"), output);
        }catch (Exception e){
            return ResponseHTTP.error(new InternalServerError());
        }
    }
}
