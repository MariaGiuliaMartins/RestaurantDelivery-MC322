package Controller;

import Model.Entregador;

import java.io.*;
import java.util.ArrayList;

public class EntregadoreController {

    private ArrayList<Entregador> entregadores;

    public EntregadoreController(ArrayList<Entregador> entregadores) {
        this.entregadores = entregadores;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/entregadores.txt"));
            while(true){
                Entregador entregador = (Entregador) input.readObject();
                this.entregadores.add(entregador);
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void addEntregador(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao){
//        Cliente cliente = new Cliente();
//    }

    public void removeEntregador(int index){

    }

    public void save() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/entregadores.txt"));
            for(Entregador entregador : this.entregadores ){
                output.writeObject(entregador);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
