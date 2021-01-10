package Models;

import java.util.ArrayList;
import java.util.Calendar;

public class Cliente extends Usuario{

    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, endereco, status, dataCriacao);
        this.pedidos = new ArrayList<Pedido>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public String avaliarPedido(Pedido pedido, float nota, String desc) {
        Avaliacao aval = new Avaliacao(nota, desc);
        return pedido.avaliarPedido(this, aval) ? "Avaliado com sucesso" : "Erro ao avaliar";
    }

    public String avaliarPedido(Pedido pedido, float nota) {
        Avaliacao aval = new Avaliacao(nota);
        return pedido.avaliarPedido(this, aval) ? "Avaliado com sucesso" : "Erro ao avaliar";
    }

    public String avaliarEntregador(Pedido pedido, float nota, String desc){
        Avaliacao aval = new Avaliacao(nota, desc);
        return pedido.avaliarEntregador(this, aval) ? "Models.Entregador avaliado com sucesso" : "Erro ao avaliar";
    }

    public String avaliarEntregador(Pedido pedido, float nota){
        Avaliacao aval = new Avaliacao(nota);
        return pedido.avaliarEntregador(this, aval) ? "Models.Entregador avaliado com sucesso" : "Erro ao avaliar";
    }

    public void fazerPedido(Pedido pedido, Restaurante restaurante){
        pedido.setCliente(this);
        restaurante.adicionarPedido(pedido);
    }
}
