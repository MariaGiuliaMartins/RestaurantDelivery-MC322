package Controller;

import Model.Entregador;
import Model.Funcionario;
import Model.Sexo;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class EntregadorController {

    private ArrayList<Entregador> entregadores;

    public EntregadorController(ArrayList<Entregador> entregadores) {
        this.entregadores = entregadores;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/entregadores.txt"));
            while(true){
                Entregador funcionario = (Entregador) input.readObject();
                Funcionario.incrementeCounter();
                this.entregadores.add(funcionario);
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Entregador> getEntregadores() {
        return entregadores;
    }

    public void save(){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/entregadores.txt"));
            for( Entregador entregador : entregadores){
                output.writeObject(entregador);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addEntregador(String nome, String cpf, String email, Sexo sexo, String telefone){
        Entregador entregador = new Entregador(nome, cpf, email, "senha", sexo, telefone, true, Calendar.getInstance());
        entregadores.add(entregador);
    }

    public void removeEntregador(ArrayList<Entregador> entregadores){
        this.entregadores.clear();
        // overwrite file
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/entregadores.txt"));
            for( Entregador entregador : entregadores){
                output.writeObject(entregador);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
