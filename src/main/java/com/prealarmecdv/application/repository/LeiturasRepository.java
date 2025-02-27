package com.prealarmecdv.application.repository;
import com.prealarmecdv.domain.entities.Leituras;
import java.time.LocalDateTime;
import java.util.List;

public interface LeiturasRepository {
    List<Leituras> getAll();
    Leituras findById(Long leituraId);
    List<Leituras> findByDistrict(final int inicio, final int fim, final LocalDateTime dataInicio, final LocalDateTime dataFim);
    List<Leituras> findAnomalias(final int kmInicio, final int kmFim,
                                      final double correnteMin, final double correnteMax,
                                      final LocalDateTime dataInicio, final LocalDateTime dataFim);
    List<Leituras> findByAddress(String address, final LocalDateTime dataInicio, final LocalDateTime dataFim);
};