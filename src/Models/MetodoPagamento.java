package Models;

public enum MetodoPagamento {
	CARTAO_CREDITO("Pagamento através do Cartão de Crédito."),
	CARTAO_DEBITO("Pagamento através do Cartão de Débito."),
	DINHEIRO("Pagamento através de Dinheiro."),
	VA("Pagamento através do Vale Alimentação"),
	VR("Pagamento através do Vale Refeição");
	
	//atributos
	private final String descricao;
	
	//construtor
	MetodoPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
