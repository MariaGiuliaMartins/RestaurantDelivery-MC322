import java.util.ArrayList;
import java.util.Calendar;

public class Entregador extends Usuario {

    private ArrayList<Pedido> pedidosFinalizados;
    private ArrayList<Pedido> pedidosPendentes;
    private ArrayList<Avaliacao> avaliacoes;

    public Entregador(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Permissoes permissoes, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, endereco, status, permissoes, dataCriacao);
    }

    public ArrayList<Pedido> getPedidosFinalizados() {
        return pedidosFinalizados;
    }

    public void setPedidosFinalizados(ArrayList<Pedido> pedidosFinalizados) {
        this.pedidosFinalizados = pedidosFinalizados;
    }

    public ArrayList<Pedido> getPedidosPendentes() {
        return pedidosPendentes;
    }

    public void setPedidosPendentes(ArrayList<Pedido> pedidosPendentes) {
        this.pedidosPendentes = pedidosPendentes;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    //Avalia o entregador
    public void avaliar(float nota, String desc){
        Avaliacao novaAval = new Avaliacao(nota, desc);
        this.avaliacoes.add(novaAval);
    }

    public void avaliar(float nota){
        Avaliacao novaAval = new Avaliacao(nota, "Sem descricao");
        this.avaliacoes.add(novaAval);
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "pedidosFinalizados=" + pedidosFinalizados +
                ", pedidosPendentes=" + pedidosPendentes +
                ", avaliacao=" + avaliacoes +
                "} " + super.toString();
    }
}
