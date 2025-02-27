package com.prealarmecdv;

import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.infra.repositroy.LeiturasRepository.LeiturasRepositoryImple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private LeiturasRepositoryImple leiturasRepositoryImple;

	@Test
	void contextLoads() {
		LocalDateTime dataInicio = LocalDateTime.parse("2025-01-22T06:02:24");
//		LocalDateTime dataInicio = LocalDateTime.parse("2025-02-03T00:00:00");
		LocalDateTime dataFim = LocalDateTime.now();
		List<Leituras> leituras = this.leiturasRepositoryImple.findAnomaliasAsync(165, 257, 0.4, 1.1, dataInicio, dataFim);
		Map<String, Map<String, List<Leituras>>> anomaliasPorCvKmECircuito = leituras.stream()
				.collect(Collectors.groupingBy(
						leitura -> leitura.getRemotaId().toString(),
						Collectors.groupingBy(Leituras::getCircuito)
				));
		for(Leituras leitura : leituras){
			System.out.println(leitura.toString());
		}
	}
}
