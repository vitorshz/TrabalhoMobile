package com.example.trabalhomobile.modelos;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private ArrayList<ItemVenda> listaItemVenda;
    private ArrayList<Item> listaItens;
    private Cliente cliente;
    private ItemVenda itemVenda;
    private double valorTotal;

    public Pedido() {
    }

    public Pedido(int id,Cliente cliente, ItemVenda itemVenda, double valorTotal) {
        this.id = id;
        this.listaItemVenda = listaItemVenda;
        this.listaItens = listaItens;
        this.cliente = cliente;
        this.itemVenda = itemVenda;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ItemVenda> getListaItemVenda() {
        return listaItemVenda;
    }

    public void setListaItemVenda(ArrayList<ItemVenda> listaItemVenda) {
        this.listaItemVenda = listaItemVenda;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
