package com.prealarmecdv.domain.DTO;
import java.time.LocalDateTime;

public record FindAnomaliasDTO(double correnteMin, double correnteMax, LocalDateTime dataInicio) {
}
