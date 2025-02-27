package com.prealarmecdv.domain.DTO;
import java.time.LocalDateTime;

public record ResponseAnomaliasDTO(Long leituraId, Long remotaId, String address, String circuito, String track, Double resistencia,
                                   Double correnteTransmitida, Double correnteRecebida, LocalDateTime dataLeitura, String rxRatio) {

}
