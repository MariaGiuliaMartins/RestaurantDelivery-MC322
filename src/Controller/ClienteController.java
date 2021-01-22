package Controller;

import Model.Cliente;
import Model.Sexo;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ClienteController {

    private ArrayList<Cliente> clientes;

    public ClienteController(ArrayList<Cliente> entregadores) {
        this.clientes = entregadores;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/clientes.txt"));
            while(true){
                Cliente funcionario = (Cliente) input.readObject();
                this.clientes.add(funcionario);
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(String nome, String cpf, String email, Sexo sexo, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, "senha", sexo, telefone, true, Calendar.getInstance());
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/clientes.txt"));
            output.writeObject(cliente);
            output.flush();
            output.close();
            clientes.add(cliente);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeCliente(ArrayList<Cliente> clientes){
        this.clientes.clear();
        // overwrite file
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/clientes.txt"));
            for( Cliente cliente : clientes){
                output.writeObject(cliente);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
