package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Entregador extends Usuario {

    private ArrayList<Pedido> pedidos;

    public Entregador(String nome, String cpf, String email, String senha, Sexo sexo, String telefone, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senha, sexo, telefone, status, dataCriacao);
        this.pedidos = new ArrayList<Pedido>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "ID: "+getId() + " Nome: "+ getNome();
    }

    //Designa um novo pedido
    public void assignPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void finalizarPedido(int idPedido){
        for (Pedido pedido: pedidos){
            if (pedido.getId() == idPedido){
                pedido.setStatus(StatusPedido.PEDIDO_ENTREGUE);
            }
        }
    }
}
