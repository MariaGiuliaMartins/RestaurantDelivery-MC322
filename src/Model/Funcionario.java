package Model;

import java.util.Calendar;

public class Funcionario extends Usuario{

    public Funcionario(String nome, String cpf, String email, String senha, Sexo sexo, String telefone, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senha, sexo, telefone, status, dataCriacao);
    }

    @Override
    public String toString() {
        return "ID: "+getId() + " Nome: "+ getNome();
    }
}