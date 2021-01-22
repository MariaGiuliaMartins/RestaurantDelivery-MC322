package Model;

import java.util.Calendar;

public class Cliente extends Usuario{

    public Cliente(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, status, dataCriacao);
    }

    @Override
    public String toString() {
        return "ID: "+getId() + " Nome: "+ getNome();
    }
}
