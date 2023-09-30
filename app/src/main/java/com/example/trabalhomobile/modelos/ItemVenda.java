package com.example.trabalhomobile.modelos;

import java.util.ArrayList;

public class ItemVenda {
    private ArrayList<ItemVenda> listaItensVenda; // O item vendido
    private Item item;
    private int quantidade; // A quantidade vendida
    private double subtotal;

    public ItemVenda() {
    }

    public ItemVenda(ArrayList<ItemVenda> listaItensVenda, int quantidade, double subtotal) {
        this.listaItensVenda = listaItensVenda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public ArrayList<ItemVenda> getListaItensVenda() {
        return listaItensVenda;
    }

    public void setListaItensVenda(ArrayList<ItemVenda> listaItensVenda) {
        this.listaItensVenda = listaItensVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
