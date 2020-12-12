import java.util.Calendar;

public class Admin extends Usuario{

    public Admin(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Permissoes permissoes, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, endereco, status, permissoes, dataCriacao);
    }

    @Override
    public String toString() {
        return "Admin{} " + super.toString();
    }
}
