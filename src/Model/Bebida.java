package Model;

public class Bebida extends ItemCardapio {
	public Bebida(String nome, String descricao, double preco, String imagem) {
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
