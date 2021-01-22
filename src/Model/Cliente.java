package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Cliente extends Usuario{

    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, status, dataCriacao);
        this.pedidos = new ArrayList<Pedido>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
