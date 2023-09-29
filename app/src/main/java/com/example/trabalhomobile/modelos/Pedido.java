package com.example.trabalhomobile.modelos;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {

    Random random = new Random();
    private int codPedido = random.nextInt(1000);
    private ArrayList<Item> listaItens;
    private double valorTotal;
    private FormaPagamento formaPagamento;
    private int numeroParcelas;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int codPedido, ArrayList<Item> listaItens, double valorTotal,
                  FormaPagamento formaPagamento, int numeroParcelas, Cliente cliente) {
        this.codPedido = codPedido;
        this.listaItens = listaItens;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.numeroParcelas = numeroParcelas;
        this.cliente = cliente;
    }
}
