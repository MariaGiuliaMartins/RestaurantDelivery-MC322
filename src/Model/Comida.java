package Model;

public class Comida extends ItemCardapio {
	public Comida(String nome, String descricao, double preco, String imagem) {
		super(nome, descricao, preco, imagem);
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
