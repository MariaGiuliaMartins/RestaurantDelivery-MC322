package Model;

import java.util.Calendar;

public class Admin extends Usuario{

    public Admin(String nome, String cpf, String email, String senha, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senha, sexo, telefone, endereco, status, dataCriacao);
    }

    @Override
    public String toString() {
        return "Models.Admin{} " + super.toString();
    }
}
