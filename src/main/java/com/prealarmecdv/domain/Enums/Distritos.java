package com.prealarmecdv.domain.Enums;

public enum Distritos {
    DISTRITO_BAC("BAC", 0, 81, "GAL1"),
    DISTRITO_VTM("VTM", 81, 165, "GAL2"),
    DISTRITO_SIS("SIS", 165, 257, "GAL2"),
    DISTRITO_AAL("AAL", 257, 335, "GAL2"),
    DISTRITO_NVA("NVA", 335, 446, "GAL2"),
    DISTRITO_ACD1("ACD1", 446, 522, "GAL3"),
    DISTRITO_ACD2("ACD2", 522, 609, "GAL3"),
    DISTRITO_SPAB("SPAB", 609, 697, "GAL3"),
    DISTRITO_MBA("MBA", 697, 784, "GAL3"),
    DISTRITO_PBA("PBA", 784, 861, "GAL4"),
    DISTRITO_CJS("CJS", 861, 889, "GAL4");

    private final String nome;
    private final int inicio;
    private final int fim;
    private final String gal;

    Distritos(String nome, int inicio, int fim, String gal) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.gal = gal;
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

    public String getGal() {
        return gal;
    }
}
