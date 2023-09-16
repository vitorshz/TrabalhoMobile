package com.example.trabalhomobile;

import com.example.trabalhomobile.modelos.Cliente;
import com.example.trabalhomobile.modelos.Item;

import java.util.ArrayList;

public class Controller {
    private static Controller instancia;
    private ArrayList<Cliente> listaClientes;

    private ArrayList<Item> listaItens;

    
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
    public ArrayList<Item> salvarItem(){return listaItens;}


}
