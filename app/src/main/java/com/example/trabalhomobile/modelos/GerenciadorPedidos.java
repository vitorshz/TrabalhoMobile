package com.example.trabalhomobile.modelos;

import java.util.ArrayList;

public class GerenciadorPedidos {
    ArrayList<Pedido> listaPedidos;

    public GerenciadorPedidos() {
    }

    public GerenciadorPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

}
