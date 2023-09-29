package com.example.trabalhomobile.modelos;

public enum FormaPagamento {
    AVISTA("À vista"),
    APRAZO("A prazo");

    private String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

