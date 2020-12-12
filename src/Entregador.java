import java.util.ArrayList;
import java.util.Calendar;

public class Entregador extends Usuario {

    private ArrayList<Pedido> pedidos;
    private ArrayList<Avaliacao> avaliacoes;

    public Entregador(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, endereco, status, dataCriacao);
        this.pedidos = new ArrayList<Pedido>();
        this.avaliacoes = new ArrayList<Avaliacao>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    //Avalia o entregador
    public void avaliar(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }

    //Designa um novo pedido
    public void assignPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }


    @Override
    public String toString() {
        return "Entregador{" +
                "pedidos=" + pedidos +
                ", avaliacao=" + avaliacoes +
                "} " + super.toString();
    }
}
