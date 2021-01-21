package Controller;

import Model.Cliente;
import Model.Endereco;
import Model.Pedido;
import Model.Sexo;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ClienteController {

    private ArrayList<Cliente> clientes;

    public ClienteController(ArrayList<Cliente> clientes) {
        this.clientes = clientes;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/clientes.txt"));
            while(true){
                Cliente cliente = (Cliente) input.readObject();
                this.clientes.add(cliente);
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void addCliente(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao){
//        Cliente cliente = new Cliente();
//    }

    public void removeCliente(int index){

    }

    public void save() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/clientes.txt"));
            for(Cliente cliente : this.clientes ){
                output.writeObject(cliente);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
