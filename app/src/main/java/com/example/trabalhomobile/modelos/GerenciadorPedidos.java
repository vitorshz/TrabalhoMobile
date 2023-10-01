package com.example.trabalhomobile.modelos;

import java.util.ArrayList;

public class GerenciadorPedidos {
    ArrayList<Pedido> listaPedidos;
    private Pedido pedido;

    public GerenciadorPedidos() {
    }

    public GerenciadorPedidos(ArrayList<Pedido> listaPedidos, Pedido pedido) {
        this.listaPedidos = listaPedidos;
        this.pedido = pedido;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
