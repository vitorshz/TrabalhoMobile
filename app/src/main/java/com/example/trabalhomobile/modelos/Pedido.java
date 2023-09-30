package com.example.trabalhomobile.modelos;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private ArrayList<Item> listaItens;
    private ArrayList<Cliente> listaClientes;
    private double valorTotal;

    public Pedido() {
    }

    public Pedido(int id, ArrayList<Item> listaItens, ArrayList<Cliente> listaClientes, double valorTotal) {
        this.id = id;
        this.listaItens = listaItens;
        this.listaClientes = listaClientes;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
