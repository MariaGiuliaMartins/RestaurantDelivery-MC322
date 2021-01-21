package Controller;

import Model.Funcionario;

import java.io.*;
import java.util.ArrayList;

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
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void addFuncionario(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao){
//        Cliente cliente = new Cliente();
//    }

    public void removeFuncionario(int index){

    }

    public void save() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/funcionarios.txt"));
            for(Funcionario funcionario : this.funcionarios ){
                output.writeObject(funcionario);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
