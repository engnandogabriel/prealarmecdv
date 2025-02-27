package com.prealarmecdv.infra.repositroy.LeiturasRepository;

import com.prealarmecdv.application.repository.LeiturasRepository;
import com.prealarmecdv.domain.entities.Leituras;
import com.prealarmecdv.infra.JPA.LeiturasJPA;
import com.prealarmecdv.infra.domain.LeiturasDomain;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LeiturasRepositoryImple implements LeiturasRepository {

    private LeiturasJPA leiturasJPA;

    public LeiturasRepositoryImple(com.prealarmecdv.infra.JPA.LeiturasJPA leiturasJPA) {
        this.leiturasJPA = leiturasJPA;
    }

    @Override
    public List<Leituras> getAll() {
        List<Leituras> leituras = this.leiturasJPA.findAll()
                .stream()
                .map(l -> Leituras.restore(l.getId(), l.getRemotaId(), l.getCircuito(),                        l.getTrack(), l.getResistencia(),
                        l.getCorrenteTransmitida(), l.getCorrenteRecebida(),
                        l.getHist(), l.getRx_ratio()))
                .collect(Collectors.toList());
        return leituras;
    }

    @Override
    public Leituras findById(Long leituraId) {
        LeiturasDomain leiturasRepostiory = this.leiturasJPA.findById(leituraId).orElse(null);
        Leituras leitura = Leituras.restore(leiturasRepostiory.getId(), leiturasRepostiory.getRemotaId(),
                leiturasRepostiory.getCircuito(), leiturasRepostiory.getTrack(),
                leiturasRepostiory.getResistencia(), leiturasRepostiory.getCorrenteTransmitida(),
                leiturasRepostiory.getCorrenteRecebida(), leiturasRepostiory.getHist(), leiturasRepostiory.getRx_ratio());
        return leitura;
    }

    @Override
    public List<Leituras> findByDistrict(int inicio, int fim, final LocalDateTime dataInicio, final LocalDateTime dataFim) {
        List<Leituras> leituras = this.leiturasJPA.findByDistrict(inicio, fim, dataInicio, dataFim)
                .stream().map(l -> Leituras.restore(l.getId(), l.getRemotaId(),l.getCircuito(),
                        l.getTrack(), l.getResistencia(),
                        l.getCorrenteTransmitida(), l.getCorrenteRecebida(), l.getHist(), l.getRx_ratio())).collect(Collectors.toList());
        return leituras;
    }

    @Override
    public List<Leituras> findAnomalias(int kmInicio, int kmFim,
                                        double correnteMin, double correnteMax,
                                        LocalDateTime dataInicio, LocalDateTime dataFim) {
        return this.leiturasJPA.findAnomalias(kmInicio, kmFim, correnteMin, correnteMax, dataInicio, dataFim)
                .stream()
                .map(l -> Leituras.restore(l.getId(), l.getRemotaId(),
                        l.getCircuito(), l.getTrack(), l.getResistencia(),
                        l.getCorrenteTransmitida(), l.getCorrenteRecebida(), l.getHist(), l.getRx_ratio()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Leituras> findByAddress(String address, final LocalDateTime dataInicio, final LocalDateTime dataFim) {
        return this.leiturasJPA.fundByAddress(address, dataInicio, dataFim)
                .stream()
                .map(l -> Leituras.restore(l.getId(), l.getRemotaId(),
                        l.getCircuito(), l.getTrack(), l.getResistencia(),
                        l.getCorrenteTransmitida(), l.getCorrenteRecebida(), l.getHist(), l.getRx_ratio()))
                .collect(Collectors.toList());
    }
}
