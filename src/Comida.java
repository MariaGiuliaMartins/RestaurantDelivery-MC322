public class Comida {
	//atributos
	public String nome;
	public String descricao;
	public double preco;
	public String imagem;
	
	//contrutor
	Comida(String nome, String descricao, double preco, String imagem){
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
		String out = "Nome da comida: " + getNome() + "\n";
		out += "Descrição da comida: " + getDescricao() + "\n";
		out += "Preço: " + getDescricao() + "\n";
		out += "Imagem: " + getImagem() + "\n";
		return out;
	}
}
