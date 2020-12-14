import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Objetos auxiliares
    	System.out.println("--------------------Criando objetos auxiliares:--------------------");
        Date date = new Date();
        System.out.println("Data: " + date.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println("Calendário: " + calendar.getTime());
        Endereco endereco = new Endereco("11", Estado.Acre, "rua", "bairro", "cidade", 20);
        System.out.println("Alguns dados do endereço: " + endereco.getLogradouro() + ", " + endereco.getNumero() + " - " + endereco.getBairro() + ".");
        Comida comida = new Comida("arroz", "gostoso", 10.0, "img");
        System.out.println("Comida: " + comida.getNome() + ", descrição: " + comida.getDescricao() + ", preço: " + comida.getPreco() + ", imagem: " + comida.getImagem());
        Bebida bebida = new Bebida("agua", "hidrate-se", 5.0, "img");
        System.out.println("Bebida: " + bebida.getNome() + ", descrição: " + bebida.getDescricao() + ", preço: " + bebida.getPreco() + ", imagem: " + bebida.getImagem());

        System.out.println();
        
        // Cria os objetos essenciais
        System.out.println("--------------------Criando objetos essenciais:--------------------");
        System.out.println("Criando tipos de Usuários: ");
      
        Cliente cliente = new Cliente("Joao", "444", "joao@gmail.com", "123", Sexo.MASCULINO, "4444",
                endereco, true, calendar);
        System.out.println(cliente.toString());
        
        Funcionario funcionario = new Funcionario("Maria", "444", "maria@gmail.com", "123", Sexo.FEMININO, "4444",
                endereco, true, calendar);
        System.out.println(funcionario.toString());
       
        Entregador entregador = new Entregador("Entregador robson", "444", "entregador@gmail.com", "123", Sexo.MASCULINO, "4444",
                endereco, true, calendar);
        System.out.println(entregador.toString());
      
        Admin admin = new Admin("admin", "444", "admin@gmail.com", "123", Sexo.FEMININO, "4444",
                endereco, true, calendar);
        System.out.println(admin.toString());

        System.out.println();
       
        System.out.println("Criando Cardápio e Restaurante:");
        Cardapio cardapio = new Cardapio();
        System.out.println(cardapio.getClass());
        Restaurante restaurante = new Restaurante("cnpj", "nome", "tem comida", cardapio, "444", "restaurante@email.com", endereco,
        true, "site");
        System.out.println("Nome do Restaurante: " + restaurante.getNome());

        System.out.println();
        
        // Inicializando restaurante
        System.out.println("--------------------Inicializando o Restaurante:--------------------");
        cardapio.criarItemCardapio(comida, funcionario);
        cardapio.criarItemCardapio(bebida, funcionario);
      
        restaurante.adicionarAdministrador(admin, admin);
        System.out.println("- Administradores: " + restaurante.getAdministradores());
      
        restaurante.adicionarFuncionario(funcionario, admin);
        System.out.println("- Funcionários: " + restaurante.getFuncionarios());
       
        restaurante.adicionarEntregador(entregador, admin);
        System.out.println("- Entregadores: " + restaurante.getEntregadores());
        
        restaurante.adicionarCardapio(cardapio, admin);
        System.out.println("- Comidas: " + restaurante.getCardapio().getComida());
        System.out.println("- Bebidas: " + restaurante.getCardapio().getBebida());
        
        System.out.println();

        // Fazendo pedido
        System.out.println("--------------------Fazendo o Pedido:--------------------");
       
        ArrayList<Comida> comidasAPedir = cardapio.getComida(); // no caso o cliente vai pedir tudo, para simplificar
        System.out.println("Comidas a serem pedidas: " + comidasAPedir);
       
        ArrayList<Bebida> bebidasAPedir = cardapio.getBebida(); // no caso o cliente vai pedir tudo, para simplificar
        System.out.println("Bebidas a serem pedidas: " + bebidasAPedir);
       
        Pedido pedido = new Pedido(calendar, calendar, cliente, comidasAPedir, bebidasAPedir, admin);
        pedido.setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO);
        pedido.setStatus(StatusPedido.PEDIDO_EM_PROCESSAMENTO);
        cliente.fazerPedido(pedido, restaurante);

        // Restaurante aceita o pedido e envia o pedido para o entregador
        System.out.println("--------------------Restaurante Aprovando, Entregando e Finalizando o Pedido:------------------------");
       
        restaurante.getPedidos().get(0).aprovarPedido(admin);
        System.out.println("Pedido aprovado.");
        
        restaurante.getPedidos().get(0).entregarPedido(admin, entregador);
        System.out.println("Pedido entregue.");
        
        entregador.finalizarPedido(pedido.getId());
        System.out.println("Pedido finalizado.");

        System.out.println();
        
        // Cliente avalia o pedido e entregador
        System.out.println("--------------------Cliente Avaliando o Pedido:--------------------");
        Avaliacao avaliacao = new Avaliacao(10, "BOM");
        pedido.avaliarPedido(cliente, avaliacao);
        pedido.avaliarEntregador(cliente, avaliacao);
        System.out.println("Avaliação: " + avaliacao.toString());
    }
}
