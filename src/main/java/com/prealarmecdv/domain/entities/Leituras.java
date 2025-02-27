package com.prealarmecdv.domain.entities;
import java.time.LocalDateTime;

public class Leituras {
    private Long leituraId;
    private Long remotaId;
    private String circuito;
    private String track;
    private Double resistencia;
    private Double correnteTransmitida;
    private Double correnteRecebida;
    private LocalDateTime hist;
    private String rxRatio;
    private Boolean preAlarme;
    private Boolean alarmeCritico;

    private Leituras(Long leituraId, Long remotaId, String circuito, String track, Double resistencia,
                     Double correnteTransmitida, Double correnteRecebida, LocalDateTime hist, String rxRatio) {
        this.leituraId = leituraId;
        this.remotaId = remotaId;
        this.circuito = circuito;
        this.track = track;
        this.resistencia = resistencia;
        this.correnteTransmitida = correnteTransmitida;
        this.correnteRecebida = correnteRecebida;
        this.hist = hist;
        this.rxRatio = rxRatio;
    }

    public static Leituras restore(final Long leituraId, final Long remotaId, final String circuito, final String track, final Double resistencia,
                                   final Double correnteTransmitida, final Double correnteRecebida, final LocalDateTime hist, final String rxRatio){
        Leituras leitura = new Leituras(leituraId, remotaId, circuito, track, resistencia, correnteTransmitida, correnteRecebida, hist, rxRatio);
        leitura.isPreAlarme();
        leitura.isAlarmeCritico();
        return leitura;

    }

    public void isPreAlarme() {
        if (this.correnteRecebida >= 0.4 && this.correnteRecebida <= 1.1) this.preAlarme = true;
    }

    public void isAlarmeCritico() {
        this.alarmeCritico = false;
        if (this.correnteRecebida < 0.4) this.alarmeCritico = true;
    }

    public Long getLeituraId() {
        return leituraId;
    }

    public Long getRemotaId() {
        return remotaId;
    }

    public String getCircuito() {
        return circuito;
    }


    public String getTrack() {
        return track;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public Double getCorrenteTransmitida() {
        return correnteTransmitida;
    }

    public Double getCorrenteRecebida() {
        return correnteRecebida;
    }

    public Boolean getPreAlarme() {
        return preAlarme;
    }

    public Boolean getAlarmeCritico() {
        return alarmeCritico;
    }

    @Override
    public String toString() {
        return "Leituras{" +
                "leituraId=" + leituraId +
                ", remotaId=" + remotaId +
                ", circuito='" + circuito + '\'' +
                ", track='" + track + '\'' +
                ", resistencia=" + resistencia +
                ", correnteTransmitida=" + correnteTransmitida +
                ", correnteRecebida=" + correnteRecebida +
                ", hist=" + hist +
                ", rxRatio='" + rxRatio + '\'' +
                ", preAlarme=" + preAlarme +
                ", alarmeCritico=" + alarmeCritico +
                '}';
    }

    public LocalDateTime getHist() {
        return hist;
    }

    public String getRxRatio() {
        return rxRatio;
    }
}
