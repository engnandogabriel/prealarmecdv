package com.prealarmecdv.application.usecases;

import com.prealarmecdv.application.repository.LeiturasRepository;
import com.prealarmecdv.application.repository.RemotaRepository;
import com.prealarmecdv.application.response.ResponseHTTP;
import com.prealarmecdv.domain.Classification.CurrentClassification;
import com.prealarmecdv.domain.Classification.ResistanceClassification;
import com.prealarmecdv.domain.DTO.FindResistanceAnomalias;
import com.prealarmecdv.domain.DTO.ResponseAnomaliasDTO;
import com.prealarmecdv.domain.Enums.Distritos;
import com.prealarmecdv.domain.Response.Response;
import com.prealarmecdv.domain.Success.GenericSuccess;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.domain.entities.Remotas;
import com.prealarmecdv.domain.exceptions.InternalServerError;
import com.prealarmecdv.domain.factories.DistritosFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindByResistanceAnomalias {
    private LeiturasRepository leiturasRepository;
    private RemotaRepository remotaRepository;

    public FindByResistanceAnomalias(LeiturasRepository leiturasRepository, RemotaRepository remotaRepository) {
        this.leiturasRepository = leiturasRepository;
        this.remotaRepository = remotaRepository;
    }

    public Response execute(String distrito, FindResistanceAnomalias data) {
        try {
            Distritos distritos = DistritosFactory.getDistrito(distrito);

            List<Leituras> leituras = this.leiturasRepository.findResistance(
                    distritos.getInicio(),
                    distritos.getFim(),
                    data.resistance(),
                    data.dataInicio(),
                    LocalDateTime.now()
            );

            Map<Long, List<Leituras>> groupedByRemotaId = leituras.stream()
                    .collect(Collectors.groupingBy(Leituras::getRemotaId));

            Set<Long> remotaIds = groupedByRemotaId.keySet();
            Map<Long, Remotas> remotasMap = this.remotaRepository.findAllById(remotaIds)
                    .stream()
                    .collect(Collectors.toMap(Remotas::getRemotaId, remota -> remota));
            ResistanceClassification classifier = new ResistanceClassification();
            Map<String, List<ResponseAnomaliasDTO>> groupedByAddress = groupedByRemotaId.entrySet()
                    .stream()
                    .flatMap(entry -> entry.getValue().stream()
                            .map(leitura -> {
                                Remotas remota = remotasMap.get(entry.getKey());
                                String classificacao = classifier.classification(leitura.getResistencia());
                                return new ResponseAnomaliasDTO(
                                        leitura.getLeituraId(),
                                        leitura.getRemotaId(),
                                        remota.getAddress(),
                                        leitura.getCircuito(),
                                        leitura.getTrack(),
                                        leitura.getResistencia(),
                                        leitura.getCorrenteTransmitida(),
                                        leitura.getCorrenteRecebida(),
                                        leitura.getHist(),
                                        leitura.getRxRatio(),
                                        classificacao
                                );
                            })
                    )
                    .collect(Collectors.groupingBy(ResponseAnomaliasDTO::address));

            return ResponseHTTP.success(new GenericSuccess("Anomalias"), groupedByAddress);

        } catch (Exception e) {
            return ResponseHTTP.error(new InternalServerError());
        }
    }
}
