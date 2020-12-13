public class ItemCardapio {
  //atributos
	private String nome;
	private String descricao;
	private double preco;
	private String imagem;
	
	//contrutor
	ItemCardapio(String nome, String descricao, double preco, String imagem){
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imagem = imagem;
	}
	
	//getters e setters
	///nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	///descricao
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	///preço
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	///imagem
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	//demais métodos
	@Override
	public String toString() {
		String out = "Item do Cardápio: " + getNome() + "\n";
		out += "Descrição do item: " + getDescricao() + "\n";
		out += "Preço: " + getPreco() + "\n";
		out += "Imagem: " + getImagem() + "\n";
		return out;
	}
}
