package com.example.trabalhomobile.modelos;

public class GerarId {
    private int proximoId = 1;

    public int gerarProximoId() {
        return proximoId++;
    }

}
