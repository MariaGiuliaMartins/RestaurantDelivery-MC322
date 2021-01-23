package Model;

import java.io.Serializable;

public class ItemCardapio implements Serializable {
  //atributos
	private static final long serialVersionUID = 302L;
	private String nome;
	private String descricao;
	private double preco;
	private String imagem;
	
	//contrutor
	public ItemCardapio(String nome, String descricao, double preco, String imagem){
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
		String out = getNome() + "\n";
		out += " - " + getPreco() + "\n";
		return out;
	}
}
