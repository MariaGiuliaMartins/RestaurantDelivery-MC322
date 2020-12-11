public enum StatusPedido {
	PEDIDO_EM_PROCESSAMENTO("O pedido está sendo processado pelo restaurante."),
	PEDIDO_RECUSADO("O restaurante recusou o pedido."),
	PEDIDO_APROVADO("O restaurante aprovou o pedido"),
	PEDIDO_EM_PREPARACAO("O restaurante está preparando o pedido."),
	PEDIDO_ENVIADO("O pedido saiu para entrega ao cliente."),
	PEDIDO_ENTREGUE("O pedido foi entregue ao cliente.");	
	
	//atributos
	private final String descricao;
	
	//construtor
	StatusPedido(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
