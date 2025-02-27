package com.prealarmecdv.domain.factories;
import com.prealarmecdv.domain.Enums.Distritos;

public class DistritosFactory {
    public static Distritos getDistrito(String name) throws Exception {
        for(Distritos distrito : Distritos.values())
            if(distrito.getNome().equalsIgnoreCase(name)) return distrito;
        throw new Exception("");
    }
}
