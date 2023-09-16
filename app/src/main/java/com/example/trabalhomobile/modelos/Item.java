package com.example.trabalhomobile.modelos;

public class Item {
    private int cod;
    private String descricao;
    private double valorUnit;

    public Item() {
    }

    public Item(int cod, String descricao, double valorUnit) {
        this.cod = cod;
        this.descricao = descricao;
        this.valorUnit = valorUnit;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }
}
