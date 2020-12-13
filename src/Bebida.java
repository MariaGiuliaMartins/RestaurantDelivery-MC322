public class Bebida extends ItemCardapio {
	public Bebida(String nome, String descricao, double preco, String imagem) {
		super(nome, descricao, preco, imagem);
	}
	
	//demais métodos
	@Override
	public String toString() {
		String out = "Nome da bebida: " + getNome() + "\n";
		out += "Descrição da bebida: " + getDescricao() + "\n";
		out += "Preço: " + getPreco() + "\n";
		out += "Imagem: " + getImagem() + "\n";
		return out;
	}
}
