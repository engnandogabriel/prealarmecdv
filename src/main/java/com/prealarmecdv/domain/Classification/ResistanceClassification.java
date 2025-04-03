package com.prealarmecdv.domain.Classification;

public class ResistanceClassification implements ClassificationInterface{
    @Override
    public String classification(double value) {
        if(value >= 2.5 && value <= 3.0) return "Criticidade Média (Possibilidade de trilho partido, cabo rompido ou conexão folgada)";
        if(value >= 3.0) return "Criticidade Alta (Possibilidade de trilho partido, cabo rompido ou conexão folgada)";
        return "Normal";
    }
}
