package com.example.trabalhomobile;

import com.example.trabalhomobile.modelos.Cliente;
import com.example.trabalhomobile.modelos.Item;
import com.example.trabalhomobile.modelos.Pedido;

import java.util.ArrayList;

public class Controller {
    private static Controller instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Item> listaItens;
    private ArrayList<Pedido> listaPedidos;

    
    public static Controller getInstance(){
        if(instancia == null){
            return instancia = new Controller();
        } else{
            return instancia;
        }
    }
    private Controller(){
        listaClientes = new ArrayList<>();
        listaItens = new ArrayList<>();
    }
    public void salvarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public ArrayList<Cliente> retornarClientes(){return listaClientes;}

    public void salvarItens(Item item){listaItens.add(item);}
    public ArrayList<Item> retornarItem(){return listaItens;}

    public void salvarPedidos(Pedido pedido){
        listaPedidos.add(pedido);
    }
    public ArrayList<Pedido> retornarPedidos(){
        return listaPedidos;
    }
}
