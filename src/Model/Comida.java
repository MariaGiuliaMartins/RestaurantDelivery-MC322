package Model;

public class Comida extends ItemCardapio {
	public Comida(String nome, String descricao, double preco, String imagem) {
		super(nome, descricao, preco, imagem);
	}

	//demais métodos
	@Override
	public String toString() {
		String out = getNome() + "\n";
		out += " - " + getPreco() + "\n";
		return out;
	}
}
