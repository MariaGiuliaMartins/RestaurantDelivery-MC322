import java.util.ArrayList;
import java.util.Calendar;

public class Cliente extends Usuario{

    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf, String email, String senhal, Sexo sexo, String telefone, Endereco endereco, boolean status, Permissoes permissoes, Calendar dataCriacao) {
        super(nome, cpf, email, senhal, sexo, telefone, endereco, status, permissoes, dataCriacao);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // TODO: chama metodo avalia na classe Pedido e pelo obejto pedido atualiza a avaliacao, algo do tipo:
    public String avaliarPedido(int pedido_index, float nota, String desc) {
        Pedido pedido = this.pedidos.get(pedido_index);
        if (pedido.getStatus() == "Pedido entregue"){
            pedido.avaliar(nota, desc);
            return "Avaliado com sucesso";
        } else if(pedido.getStatus() == "Pedido avaliado"){
            return "Pedido ja avaliado";
        }
        return "Pedido nao encontrado";
    }

    public String avaliarPedido(int pedido_index, float nota) {
        Pedido pedido = this.pedidos.get(pedido_index);
        if (pedido.getStatus() == "Pedido entregue"){
            pedido.avaliar(nota);
            return "Avaliado com sucesso";
        } else if(pedido.getStatus() == "Pedido avaliado"){
            return "Pedido ja avaliado";
        }
        return "Pedido nao encontrado";
    }

    public String avaliarEntregador(int pedido_index, float nota, String desc){
        Entregador entregador = this.pedidos.get(pedido_index).getEntregador();
        entregador.avaliar(nota);
        return "Entregador avaliado com sucesso";
    }

    public String avaliarEntregador(int pedido_index, float nota){
        Entregador entregador = this.pedidos.get(pedido_index).getEntregador();
        entregador.avaliar(nota);
        return "Entregador avaliado com sucesso";
    }

    //TODO fazer pedido

}
