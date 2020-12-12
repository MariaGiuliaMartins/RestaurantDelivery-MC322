import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Objetos auxiliares
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Endereco endereco = new Endereco("11", Estado.Acre, "rua", "bairro", "cidade", 20);
        Comida comida = new Comida("arroz", "gostoso", 10.0, "img");
        Bebida bebida = new Bebida("agua", "hidrate-se", 5.0, "img");


        // Cria os objetos essenciais
        Cliente cliente = new Cliente("Joao", "444", "joao@gmail.com", "123", Sexo.MASCULINO, "4444",
                endereco, true, calendar);
        Funcionario funcionario = new Funcionario("Maria", "444", "maria@gmail.com", "123", Sexo.FEMININO, "4444",
                endereco, true, calendar);
        Entregador entregador = new Entregador("Entregador robson", "444", "entregador@gmail.com", "123", Sexo.MASCULINO, "4444",
                endereco, true, calendar);
        Admin admin = new Admin("admin", "444", "admin@gmail.com", "123", Sexo.FEMININO, "4444",
                endereco, true, calendar);

        Cardapio cardapio = new Cardapio();
        Restaurante restaurante = new Restaurante("cnpj", "nome", "tem comida", cardapio, "444", endereco,
        true, "site");

        // Inicializando restaurante
        cardapio.criarItemCardapio(comida, bebida, funcionario);
        restaurante.adicionarAdministrador(admin, admin);
        restaurante.adicionarFuncionario(funcionario, admin);
        restaurante.adicionarEntregador(entregador, admin);
        restaurante.adicionarCardapio(cardapio, admin);

        // Fazendo pedido
        ArrayList<Comida> comidas_a_pedir = cardapio.getComida(); // no caso o cliente vai pedir tudo, para simplificar
        ArrayList<Bebida> bebidas_a_pedir = cardapio.getBebida(); // no caso o cliente vai pedir tudo, para simplificar
        Pedido pedido = new Pedido(calendar, calendar, cliente, comidas_a_pedir, bebidas_a_pedir, 15.0, admin);
        pedido.setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO);
        pedido.setStatus(StatusPedido.PEDIDO_EM_PROCESSAMENTO);
        cliente.fazerPedido(pedido, restaurante);

        // Restaurante aceita o pedido e envia o pedido para o entregador
        restaurante.getPedidos().get(0).aprovarPedido(admin);
        restaurante.getPedidos().get(0).entregarPedido(admin, entregador);
        entregador.finalizarPedido(pedido.getId());

        // Cliente avalia o pedido e entregador
        Avaliacao avaliacao = new Avaliacao(10, "BOM");
        pedido.avaliarPedido(cliente, avaliacao);
        pedido.avaliarEntregador(cliente, avaliacao);











    }
}
