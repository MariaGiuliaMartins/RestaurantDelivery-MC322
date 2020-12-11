import java.util.ArrayList;

public class Cardapio {
	//atributos
	private ArrayList<Comida> comidas;
	private ArrayList<Bebida> bebidas;
	
	//construtor
	Cardapio(ArrayList<Comida> comidas, ArrayList<Bebida> bebidas){
		this.comidas = new ArrayList<Comida>();
		this.bebidas = new ArrayList<Bebida>();
	}
	
	//getters e setters
	///comida
	public ArrayList<Comida> getComida(){
		return comidas;
	}
	
	///bebida
	public ArrayList<Bebida> getBebida(){
		return bebidas;
	}
	
	//demais métodos
	///criar item do cardápio
	public boolean criarItemCardapio(Comida comida, Bebida bebida, Usuario usuario) {
		/*
		 * Função que adiciona uma comida ou uma bebida no cardapio através de um usuário (funcionário ou admin)
		 * Input: um item de comida, um item de bebida, usuario que adicionará o alimento
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		//primeiro checamos se o usuario é um funcionário ou um admin
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			int aux_c = 0; //auxiliar para contadora de comida
			//agora devemos ver se a comida já existe no cardápio
			for(int i = 0; i < this.comidas.size(); i++) {
				if(this.comidas.get(i) == comida) { //se a comida já existe, vamos checar seu valor
					aux_c++; //incrementamos a auxiliar de comida
					}
				}
			if(aux_c == 0) { //se a auxilar de comida não incrementar, então essa comida não existe no cardapio
				this.comidas.add(comida); //então adicionamos
				System.out.println("Comida adicionada com sucesso!");
			}
			//vamos fazer a mesma coisa para a bebida
			int aux_b = 0; //auxiliar contadora de bebida
			for(int i = 0; i < this.bebidas.size(); i++) {
				if(this.bebidas.get(i) == bebida) { //se a bebida já existe, vamos checar seu valor
					aux_b++; //incrementamos auxiliar de bebida
				}
			}
			if(aux_b == 0) { //se a auxilar de bebida não incrementar, então essa bebida não existe no cardapio
				this.bebidas.add(bebida); //então adicionamos
				System.out.println("Bebida adicionada com sucesso!");
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	
	///remover item do cardápio
	public boolean removerItemCardapio(Comida comida, Bebida bebida, Usuario usuario) {
		/*
		 * Função que remove uma comida ou uma bebida no cardapio através de um usuário (funcionário ou admin)
		 * Input: um item de comida, um item de bebida, usuario que removerá o alimento
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		//primeiro checamos se o usuario é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//agora vemos se a comida existe
			for(int i = 0; i < this.comidas.size(); i++) {
				if(this.comidas.get(i) == comida) { //se ela existir, removemos
					this.comidas.remove(i);
					System.out.println("Comida removida com sucesso!");
				}
			}
			//fazemos a mesma coisa para a bebida
			for(int i = 0; i < this.bebidas.size(); i++) {
				if(this.bebidas.get(i) == bebida) { //se ela existir, removemos
					this.bebidas.remove(i);
					System.out.println("Bebida removida com sucesso!");
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	///editar item do cardápio
	public boolean editarItemCardapio(Comida comida, Bebida bebida, Usuario usuario) {
		/*
		 * Função que edita um alimento do cardapio através de um usuário (funcionário ou admin)
		 * Input: um item de comida, um item de bebida, usuario que editará o alimento
		 * Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
		 */
		//primeiro checamos se o usuário que fará a edição é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//agora vemos se a comida existe no cardápio para se editada
			for(int i = 0; i < this.comidas.size(); i++) {
				if(this.comidas.get(i).getNome() == comida.getNome()) { //se a comida existe, começamos as comparações
					if(this.comidas.get(i).getDescricao() != comida.getDescricao()) { //se a descrição for diferente, atualizamos
						this.comidas.get(i).descricao = comida.getDescricao();
					}
					if(this.comidas.get(i).getPreco() != comida.getPreco()){ //se o preço for diferente, atualizamos
						this.comidas.get(i).preco = comida.getPreco();
					}
					if(this.comidas.get(i).getImagem() != comida.getImagem()){ //se a imagem for diferente, atualizamos
						this.comidas.get(i).imagem = comida.getImagem();
					}	
				}
			}
			//fazemos a mesma coisa para a bebida
			for(int i = 0; i < this.bebidas.size(); i++) {
				if(this.bebidas.get(i).getNome() == bebida.getNome()) { //se a bebida existe, começamos as comparações
					if(this.bebidas.get(i).getDescricao() != bebida.getDescricao()) { //se a descrição for diferente, atualizamos
						this.bebidas.get(i).descricao = bebida.getDescricao();
					}
					if(this.bebidas.get(i).getPreco() != bebida.getPreco()){ //se o preço for diferente, atualizamos
						this.bebidas.get(i).preco = bebida.getPreco();
					}
					if(this.bebidas.get(i).getImagem() != bebida.getImagem()){ //se a imagem for diferente, atualizamos
						this.bebidas.get(i).imagem = bebida.getImagem();
					}	
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	
	///toString
	@Override
	public String toString() {
		String out = "Comidas do Cardápio: \n";
		for(int i = 0; i < this.comidas.size(); i++) {
			out += "-- Comida " + i + ":"; 
			out += "Nome: " + this.comidas.get(i).getNome() + ", ";
			out += "Descrição: " + this.comidas.get(i).getDescricao() + ", ";
			out += "Preço: " + this.comidas.get(i).getPreco() + ", ";
			out += "Imagem: " + this.comidas.get(i).getImagem() + ";"+  "\n";
		}
		out += "\n";
		out = "Bebidas do Cardápio: \n";
		for(int i = 0; i < this.bebidas.size(); i++) {
			out += "-- Bebida " + i + ":"; 
			out += "Nome: " + this.bebidas.get(i).getNome() + ", ";
			out += "Descrição: " + this.bebidas.get(i).getDescricao() + ", ";
			out += "Preço: " + this.bebidas.get(i).getPreco() + ", ";
			out += "Imagem: " + this.bebidas.get(i).getImagem() + ";"+  "\n";
		}
		return out;
	}
}
