package com.example.trabalhomobile.modelos;

public class Parcela {
    private int numero;
    private double valor;

    public Parcela(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return numero + "x R$ " + String.format("%.2f", valor);
    }
}
