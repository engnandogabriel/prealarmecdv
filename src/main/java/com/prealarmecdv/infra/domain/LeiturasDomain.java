package com.prealarmecdv.infra.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbleituras")
public class LeiturasDomain {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "remota_id")
    private Long remotaId;
    @Column(name = "circuito")
    private String circuito;
    @Column(name = "track")
    private String track;
    @Column(name = "resistencia")
    private Double resistencia;
    @Column(name = "corrente_transmitida")
    private Double correnteTransmitida;
    @Column(name = "corrente_recebida")
    private Double correnteRecebida;
    @Column(name = "slot")
    private String slot;
    @Column(name = "checksum_sw_app")
    private String checksumSwApp;
    @Column(name = "sw_date")
    private LocalDateTime swDate;
    @Column(name = "hist")
    private LocalDateTime hist;
    @Column(name = "rx_ratio")
    private String rx_ratio;

    public LeiturasDomain(Long id, Long remotaId, String circuito,
                          String track, Double resistencia,
                          Double correnteTransmitida, Double correnteRecebida, String slot,
                          String checksumSwApp, LocalDateTime swDate, LocalDateTime hist, String rx_ratio) {
        this.id = id;
        this.remotaId = remotaId;
        this.circuito = circuito;
        this.track = track;
        this.resistencia = resistencia;
        this.correnteTransmitida = correnteTransmitida;
        this.correnteRecebida = correnteRecebida;
        this.slot = slot;
        this.checksumSwApp = checksumSwApp;
        this.swDate = swDate;
        this.hist = hist;
        this.rx_ratio = rx_ratio;
    }

    public LeiturasDomain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemotaId() {
        return remotaId;
    }

    public void setRemotaId(Long remotaId) {
        this.remotaId = remotaId;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public void setResistencia(Double resistencia) {
        this.resistencia = resistencia;
    }

    public Double getCorrenteTransmitida() {
        return correnteTransmitida;
    }

    public void setCorrenteTransmitida(Double correnteTransmitida) {
        this.correnteTransmitida = correnteTransmitida;
    }

    public Double getCorrenteRecebida() {
        return correnteRecebida;
    }

    public void setCorrenteRecebida(Double correnteRecebida) {
        this.correnteRecebida = correnteRecebida;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getChecksumSwApp() {
        return checksumSwApp;
    }

    public void setChecksumSwApp(String checksumSwApp) {
        this.checksumSwApp = checksumSwApp;
    }

    public LocalDateTime getSwDate() {
        return swDate;
    }

    public void setSwDate(LocalDateTime swDate) {
        this.swDate = swDate;
    }

    public LocalDateTime getHist() {
        return hist;
    }

    public void setHist(LocalDateTime hist) {
        this.hist = hist;
    }

    public String getRx_ratio() {
        return rx_ratio;
    }

    public void setRx_ratio(String rx_ratio) {
        this.rx_ratio = rx_ratio;
    }
}
