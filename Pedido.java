import java.util.Calendar;
import java.util.GregorianCalendar;

import org.graalvm.compiler.phases.verify.VerifyGetOptionsUsage;

import java.util.ArrayList;

public class Pedido {
	//atributos
	private static int numeroPedidos = 0;
	private final int id;
	private Calendar dataCriacao;
	private Calendar dataEntrega;
	private Usuario cliente;
	private ArrayList<Comida> comidas;
	private ArrayList<Bebida> bebidas;
	private double valor;
	private StatusPedido status;
	private Usuario responsavel;
	private MetodoPagamento metodoPagamento;
	
	//construtor
	public Pedido(Calendar dataCriacao, Calendar dataEntrega, Usuario cliente, ArrayList<Comida> comidas, ArrayList<Bebida> bebidas, double valor, Usuario responsavel) {
		id = Pedido.numeroPedidos++;
		numeroPedidos++;
		this.dataCriacao = dataCriacao;
		this.dataEntrega = dataEntrega;
		this.cliente = cliente;
		this.comidas = new ArrayList<Comida>();
		this.bebidas = new ArrayList<Bebida>();
		this.valor = valor;
		this.responsavel = responsavel;
	}
	
	//getters e setters
	///numero de pedidos
	public static int getNumeroPedidos() {
		return numeroPedidos;
	}
	
	public static int setNumeroPedidos(int numeroPedidos) {
		Pedido.numeroPedidos = numeroPedidos;
	}
	
	///id
	public final int getId() {
		return id;
	}
	
	///data de criação
	public String getDataCriacao() {
		return (String)(dataCriacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataCriacao.get(GregorianCalendar.MONTH) + "/" + dataCriacao.get(GregorianCalendar.YEAR));
	}
	
	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}	
	public void setDataCriacao(int dia, int mes, int ano) {
		dataCriacao.set(GregorianCalendar.DATE, dia);
		dataCriacao.set(GregorianCalendar.MONTH, mes);
		dataCriacao.set(GregorianCalendar.YEAR, ano);
	}
	
	///data de entrega
	public String getDataEntrega() {
		return (String)(dataCriacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataCriacao.get(GregorianCalendar.MONTH) + "/" + dataCriacao.get(GregorianCalendar.YEAR));
	}
	
	public void setDataEtrega(GregorianCalendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}	
	public void setDataEntrega(int dia, int mes, int ano) {
		dataCriacao.set(GregorianCalendar.DATE, dia);
		dataCriacao.set(GregorianCalendar.MONTH, mes);
		dataCriacao.set(GregorianCalendar.YEAR, ano);
	}
	
	///cliente
	public Usuario getCliente() {
		return cliente;
	}
	
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
		
	///valor
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	///status
	public StatusPedido getStatus() {
		return status;
	}
	
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
		
	///responsavel
	public Usuario getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	
	
	///metodo de pagamento
	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}
	
	
	///comida
	public ArrayList<Comida> getComida(){
		return comidas;
	}
	
	///bebida
	public ArrayList<Bebida> getBebida(){
		return bebidas;
	}
	
	
	//métodos
	///adicionar comida
	public boolean adicionarComida(Comida comida, int quant) {
		/*
		 * Função que adiciona um tipo de comida no array list de comida do pedido, bem como sua quantidade	
		 * Input: comida e quantidade de comida
		 * Output: boolean - true significa que foi adicionado com sucesso, false significa que algo de errado ocorreu
		*/
		//primeiro checamos se esta comida já está no array list, pois pode ser apenas uma atualização de quantidade
		int aux1 = 0; //auxiliar para ver a quantidade já contida
		int aux2 = 0; //auxiliar para determinar a quantidade a ser adicionada
		for(int i = 0; i < this.getComida().size(); i++) {
			if(this.getComida().get(i) == comida) { //se já temos essa comida na lista de comidas
				aux1++; //contabilizamos quantas vezes ela já está na lista de comida				
			}
		}
		
		aux2 += quant - aux1; //atualizamos o auxiliar para adicionar a nova quantidade
		if(aux2 == 0) { //se a quantidade a ser adicionada for zero, então não precisa adicionar, sequer chamar este método
			return false;
		}
		else { 
			for(int i = 0; i < aux2; i++) {
				this.getComida().add(comida);
			}
			return true;
		}
	}
	
	
	///remover comida
	public boolean removerComida(Comida comida, int quant) {
		/*
		 * Função que remove um tipo de comida no array list de comida do pedido, bem como sua quantidade	
		 * Input: comida e quantidade de comida
		 * Output: boolean - true significa que foi removido com sucesso, false significa que algo de errado ocorreu
		*/
		//primeiro checamos se esta comida existe no array list, pois pode ser apenas uma atualização de quantidade
		int aux1 = 0; //auxiliar para ver a quantidade já contida
		for(int i = 0; i < this.getComida().size(); i++) {
			if(this.getComida().get(i) == comida) { //se já temos essa comida na lista de comidas
				aux1++; //contabilizamos quantas vezes ela já está na lista de comida				
			}
		}
		
		if(quant <= aux1) { //se a quantidade a ser removida é menor ou igual do que a existente
			while(quant > 0) {
				for(int i = 0; i < this.getComida().size(); i++) {
					if(this.getComida().get(i) == comida) {
						this.getComida().remove(i);
					}
				}
				quant--; //decrementamos a quantidade a ser removida
			}
			return true;
		}
		else { 
			return false;
		}
	}
	
	///adicionar bebida
	public boolean adicionarBebida(Bebida bebida, int quant) {
		/*
		 * Função que adiciona um tipo de bebida no array list de bebida do pedido, bem como sua quantidade	
		 * Input: bebida e quantidade de bebida
		 * Output: boolean - true significa que foi adicionado com sucesso, false significa que algo de errado ocorreu
		*/
		//primeiro checamos se esta bebida já está no array list, pois pode ser apenas uma atualização de quantidade
		int aux1 = 0; //auxiliar para ver a quantidade já contida
		int aux2 = 0; //auxiliar para determinar a quantidade a ser adicionada
		for(int i = 0; i < this.getBebida().size(); i++) {
			if(this.getBebida().get(i) == comida) { //se já temos essa bebida na lista de bebidas
				aux1++; //contabilizamos quantas vezes ela já está na lista de bebida				
			}
		}
		
		aux2 += quant - aux1; //atualizamos o auxiliar para adicionar a nova quantidade
		if(aux2 == 0) { //se a quantidade a ser adicionada for zero, então não precisa adicionar, sequer chamar este método
			return false;
		}
		else { 
			for(int i = 0; i < aux2; i++) {
				this.getBebida().add(bebida);
			}
			return true;
		}
	}
	
	///remover bebida
	public boolean removerBebida(Bebida bebida, int quant) {
		/*
		 * Função que remove um tipo de bebida no array list de bebida do pedido, bem como sua quantidade	
		 * Input: bebida e quantidade de bebida
		 * Output: boolean - true significa que foi removido com sucesso, false significa que algo de errado ocorreu
		*/
		//primeiro checamos se esta bebida existe no array list, pois pode ser apenas uma atualização de quantidade
		int aux1 = 0; //auxiliar para ver a quantidade já contida
		for(int i = 0; i < this.getBebida().size(); i++) {
			if(this.getBebida().get(i) == bebida) { //se já temos essa comida na lista de bebida
				aux1++; //contabilizamos quantas vezes ela já está na lista de bebida				
			}
		}
		
		if(quant <= aux1) { //se a quantidade a ser removida é menor ou igual do que a existente
			while(quant > 0) {
				for(int i = 0; i < this.getBebida().size(); i++) {
					if(this.getBebida().get(i) == bebida) {
						this.getBebida().remove(i);
					}
				}
				quant--; //decrementamos a quantidade a ser removida
			}
			return true;
		}
		else { 
			return false;
		}
	}
	
	///modificar o status do pedido
	public boolean modificarStatusPedido(StatusPedido status) {
		/*
		 * Função que modifica o status do pedido conforme parâmetro passado na função
		 * Input: status novo a ser substituido pelo anterior
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		if (status == StatusPedido.PEDIDO_EM_PROCESSAMENTO || status == StatusPedido.PEDIDO_RECUSADO || status == StatusPedido.PEDIDO_APROVADO || status == StatusPedido.PEDIDO_EM_PREPARACAO || status == StatusPedido.PEDIDO_ENVIADO || status == StatusPedido.PEDIDO_ENTREGUE) {
			this.status = status;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	///modificar metodo de pagamento
	public boolean setMetodoPagamento(MetodoPagamento metodoPagamento) {
		/*
		 * Função que adiciona o método de pagamento do pedido conforme parâmetro passado na função
		 * Input: metodo de pagamento 
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO || metodoPagamento == MetodoPagamento.CARTAO_DEBITO || metodoPagamento == MetodoPagamento.DINHEIRO || metodoPagamento == MetodoPagamento.VA || metodoPagamento == MetodoPagamento.VR) {
			this.metodoPagamento = metodoPagamento;
			return true;
		}
		else {
			return false;
		}
	}
	
	///aprovar pedido
	public boolean aprovarPedido(Usuario aprovador) {
		/*
		 * Função que aprova o pedido de um cliente
		 * Input: usuário que possui a permissão de aprovar o pedido
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		//se o usuario possuir uma permissão de aprovar pedidos, ou for um funcionário ou um admin
		if(aprovador.getPermissoes() == APROVAR_PEDIDO || aprovador.getClass() == Admin || aprovador.getClass() == Funcionario) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	///toString
	@Override
	public String toString() {
		String out = "id do pedido: " + getId() + "\n";
		out += "Data do pedido: " + getDataCriacao() + "\n";
		out += "Data de entrega do pedido: " + getDataEntrega() + "\n";
		out += "Cliente: " + getCliente() + "\n";
		out += "Lista de comidas: \n";
		for (int i = 0; i < this.comidas.size(); i++) {
			out += "--> " + this.comidas.get(i) + "\n"; 
		}
		out += "Lista de bebidas: \n";
		for (int i = 0; i < this.bebidas.size(); i++) {
			out += "--> " + this.bebidas.get(i) + "\n"; 
		}
		out += "Valor do pedido: " + getValor() + "\n";
		out += "Responsável pelo pedido: " + getResponsavel() + "\n";
		out += "Método de Pagamento do pedido: " + getMetodoPagamento() + "\n";
		return out;
	}
	
}
