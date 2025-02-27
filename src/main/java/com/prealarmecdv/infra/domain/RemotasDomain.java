package com.prealarmecdv.infra.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbremota")
public class RemotasDomain {

    @Id
    @Column(name = "id")
    private Long remotaId;
    @Column(name = "local_id")
    private Long localId;
    @Column(name = "ip")
    private String ip;
    @Column(name = "descricao")
    protected String descricao;
    @Column(name = "name")
    private String name;
    @Column(name = "railroad")
    private String railroad;
    @Column(name = "subdivision")
    private String subdivision;
    @Column(name = "address")
    private String address;
    @Column(name = "siteId")
    private String site_id;
    @Column(name = "chassisId")
    private String chassis_id;
    @Column(name = "checksum_sw_exec")
    private String checksumSwExec;
    @Column(name = "sw_date")
    private LocalDateTime swDate;
    @Column(name = "ativa")
    private Integer ativa;
    @Column(name = "hist")
    private LocalDateTime hist;

    public RemotasDomain(Long remotaId, Long localId, String ip, String descricao, String name, String railroad, String subdivision, String address, String site_id, String chassis_id, String checksumSwExec, LocalDateTime swDate, Integer ativa, LocalDateTime hist) {
        this.remotaId = remotaId;
        this.localId = localId;
        this.ip = ip;
        this.descricao = descricao;
        this.name = name;
        this.railroad = railroad;
        this.subdivision = subdivision;
        this.address = address;
        this.site_id = site_id;
        this.chassis_id = chassis_id;
        this.checksumSwExec = checksumSwExec;
        this.swDate = swDate;
        this.ativa = ativa;
        this.hist = hist;
    }

    public RemotasDomain() {
    }

    public Long getRemotaId() {
        return remotaId;
    }

    public void setRemotaId(Long remotaId) {
        this.remotaId = remotaId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRailroad() {
        return railroad;
    }

    public void setRailroad(String railroad) {
        this.railroad = railroad;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getChassis_id() {
        return chassis_id;
    }

    public void setChassis_id(String chassis_id) {
        this.chassis_id = chassis_id;
    }

    public String getChecksumSwExec() {
        return checksumSwExec;
    }

    public void setChecksumSwExec(String checksumSwExec) {
        this.checksumSwExec = checksumSwExec;
    }

    public LocalDateTime getSwDate() {
        return swDate;
    }

    public void setSwDate(LocalDateTime swDate) {
        this.swDate = swDate;
    }

    public Integer getAtiva() {
        return ativa;
    }

    public void setAtiva(Integer ativa) {
        this.ativa = ativa;
    }

    public LocalDateTime getHist() {
        return hist;
    }

    public void setHist(LocalDateTime hist) {
        this.hist = hist;
    }
}
