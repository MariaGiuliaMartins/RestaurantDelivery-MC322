package Controller;

import Model.Funcionario;
import Model.Sexo;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class FuncionarioController {

    private ArrayList<Funcionario> funcionarios;

    public FuncionarioController(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/funcionarios.txt"));
            while(true){
                Funcionario funcionario = (Funcionario) input.readObject();
                this.funcionarios.add(funcionario);
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(String nome, String cpf, String email, Sexo sexo, String telefone){
        Funcionario funcionario = new Funcionario(nome, cpf, email, "senha", sexo, telefone, true, Calendar.getInstance());
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/funcionarios.txt"));
            output.writeObject(funcionario);
            output.flush();
            output.close();
            funcionarios.add(funcionario);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeFuncionario(ArrayList<Funcionario> funcionarios){
        this.funcionarios.clear();
        // overwrite file
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/funcionarios.txt"));
            for( Funcionario funcionario : funcionarios){
                output.writeObject(funcionario);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}