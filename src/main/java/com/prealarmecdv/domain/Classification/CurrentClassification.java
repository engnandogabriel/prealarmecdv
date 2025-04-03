package com.prealarmecdv.domain.Classification;

public class CurrentClassification implements  ClassificationInterface{
    @Override
    public String classification(double value) {
        if(value <= 0.4) return "Criticidade Alta (Possibilidade de curto-circuito)";
        if(value > 0.4 && value <= 1.1) return "Criticidade Média (Possibilidade de curto-circuito)";
        if(value > 1.1) return "Criticidade Baixa (Possibilidade de curto-circuito)";
        return "Normal";
    }
}
