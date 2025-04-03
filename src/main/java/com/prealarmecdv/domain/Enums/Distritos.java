package com.prealarmecdv.domain.Enums;

public enum Distritos {
    DISTRITO_NVD("VTM", 81, 165),
    DISTRITO_SIS("SIS", 165, 257),
    DISTRITO_AAL("AAL", 257, 335),
    DISTRITO_NVA("NVA", 335, 446);

    private final String nome;
    private final int inicio;
    private final int fim;

    Distritos(String nome, int inicio, int fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getNome() {
        return nome;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }
}
