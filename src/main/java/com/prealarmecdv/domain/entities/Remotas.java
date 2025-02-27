package com.prealarmecdv.domain.entities;
import java.time.LocalDateTime;

public class Remotas {

    private Long remotaId;
    private Long localId;
    private String ip;
    private String descricao;
    private String name;
    private String railroad;
    private String subdivision;
    private String address;
    private String siteId;
    private String chassisId;
    private String checksumSwExec;
    private LocalDateTime swDate;
    private Integer ativa;
    private LocalDateTime hist;


    private Remotas(Long remotaId, Long localId, String ip, String descricao,
                   String name, String railroad, String subdivision, String address,
                   String site_id, String chassisId, String checksumSwExec,
                   LocalDateTime swDate, Integer ativa, LocalDateTime hist) {
        this.remotaId = remotaId;
        this.localId = localId;
        this.ip = ip;
        this.descricao = descricao;
        this.name = name;
        this.railroad = railroad;
        this.subdivision = subdivision;
        this.address = address;
        this.siteId = site_id;
        this.chassisId = chassisId;
        this.checksumSwExec = checksumSwExec;
        this.swDate = swDate;
        this.ativa = ativa;
        this.hist = hist;
    }
    public static Remotas restore(final Long remotaId, final Long localId, final String ip, final String descricao,
                          final String name, final String railroad, final String subdivision, final String address,
                          final String siteId, final String chassisId, final String checksumSwExec,
                          final LocalDateTime swDate, final Integer ativa, final LocalDateTime hist){
        return new Remotas(remotaId, localId, ip, descricao, name, railroad, subdivision, address, siteId, chassisId, checksumSwExec, swDate, ativa, hist);
    }

    public Long getRemotaId() {
        return remotaId;
    }

    public Long getLocalId() {
        return localId;
    }

    public String getIp() {
        return ip;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getName() {
        return name;
    }

    public String getRailroad() {
        return railroad;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getAddress() {
        return address;
    }

    public String getSiteId() {
        return siteId;
    }

    public String getChassisId() {
        return chassisId;
    }

    public String getChecksumSwExec() {
        return checksumSwExec;
    }

    public LocalDateTime getSwDate() {
        return swDate;
    }

    public Integer getAtiva() {
        return ativa;
    }

    public LocalDateTime getHist() {
        return hist;
    }
}
