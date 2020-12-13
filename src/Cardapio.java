import java.util.ArrayList;
import java.util.Collections;

public class Cardapio {
	//atributos
	private ArrayList<Comida> comidas;
	private ArrayList<Bebida> bebidas;
	
	//construtor
	Cardapio(){
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
	
	/* Métodos */

	///criar item do cardápio
	/*
		* Função que adiciona uma comida no cardapio através de um usuário (funcionário ou admin)
		* Input: um item de comida, usuario que adicionará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean criarItemCardapio(Comida comida, Usuario usuario) {
		//primeiro checamos se o usuario é um funcionário ou um admin
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			int auxComida = Collections.frequency(this.comidas, comida); //auxiliar para contadora de comida

			if(auxComida == 0) { //se a auxiliar de comida for 0, então essa comida não existe no cardapio
				this.comidas.add(comida); //então adicionamos
				System.out.println("Comida adicionada com sucesso!");
			}

			return true;
		}

		return false;
	}

	///criar item do cardápio
	/*
		* Função que adiciona uma bebida no cardapio através de um usuário (funcionário ou admin)
		* Input: um item de bebida, usuario que adicionará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean criarItemCardapio(Bebida bebida, Usuario usuario) {
		//primeiro checamos se o usuario é um funcionário ou um admin
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//vamos fazer a mesma coisa para a bebida
			int auxBebida = Collections.frequency(this.bebidas, bebida); //auxiliar contadora de bebida

			if(auxBebida == 0) { //se a auxilar de bebida não incrementar, então essa bebida não existe no cardapio
				this.bebidas.add(bebida); //então adicionamos
				System.out.println("Bebida adicionada com sucesso!");
			}

			return true;
		}

		return false;
	}
	
	///remover item do cardápio
	/*
		* Função que remove uma comida do cardapio através de um usuário (funcionário ou admin)
		* Input: um item de comida, usuario que removerá o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean removerItemCardapio(Comida comida, Usuario usuario) {
		//primeiro checamos se o usuario é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//agora vemos se a comida existe
			if (this.comidas.contains(comida)) {
				this.comidas.remove(comida);
				System.out.println("Comida removida com sucesso!");
			}

			return true;
		}
			
		return false;
	}

	///remover item do cardápio
	/*
		* Função que remove uma bebida do cardapio através de um usuário (funcionário ou admin)
		* Input: um item de bebida, usuario que removerá o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean removerItemCardapio(Bebida bebida, Usuario usuario) {
		//primeiro checamos se o usuario é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//verificamos se a bebida existe no cardápio
			if (this.bebidas.contains(bebida)) {
				this.bebidas.remove(bebida);
				System.out.println("Bebida removida com sucesso!");
			}

			return true;
		}
			
		return false;
	}
	
	///editar item do cardápio
	/*
		* Função que edita uma comida do cardapio através de um usuário (funcionário ou admin)
		* Input: um item de comida, usuario que editará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean editarItemCardapio(Comida comida, Usuario usuario) {
		//primeiro checamos se o usuário que fará a edição é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//agora vemos se a comida existe no cardápio para se editada
			for(int i = 0; i < this.comidas.size(); i++) {
				if(this.comidas.get(i).getNome().equals(comida.getNome())) { //se a comida existe, começamos as comparações
					if(!this.comidas.get(i).getDescricao().equals(comida.getDescricao())) { //se a descrição for diferente, atualizamos
						this.comidas.get(i).setDescricao(comida.getDescricao());
					}

					if(this.comidas.get(i).getPreco() != comida.getPreco()){ //se o preço for diferente, atualizamos
						this.comidas.get(i).setPreco(comida.getPreco());
					}
					
					if(this.comidas.get(i).getImagem().equals(comida.getImagem())){ //se a imagem for diferente, atualizamos
						this.comidas.get(i).setImagem(comida.getImagem());
					}	
				}
			}

			return true;
		}

		return false;
	}

	///editar item do cardápio
	/*
		* Função que edita uma bebida do cardapio através de um usuário (funcionário ou admin)
		* Input: um item de bebida, usuario que editará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean editarItemCardapio(Bebida bebida, Usuario usuario) {
		//primeiro checamos se o usuário que fará a edição é admin ou funcionário
		if(usuario.getClass() == Admin.class || usuario.getClass() == Funcionario.class) {
			//verificamos se a bebida existe no cardápio
			for(int i = 0; i < this.bebidas.size(); i++) {
				if(this.bebidas.get(i).getNome().equals(bebida.getNome())) { //se a bebida existe, começamos as comparações
					if(!this.bebidas.get(i).getDescricao().equals(bebida.getDescricao())) { //se a descrição for diferente, atualizamos
						this.bebidas.get(i).setDescricao(bebida.getDescricao());
					}

					if(this.bebidas.get(i).getPreco() != bebida.getPreco()){ //se o preço for diferente, atualizamos
						this.bebidas.get(i).setPreco(bebida.getPreco());
					}

					if(!this.bebidas.get(i).getImagem().equals(bebida.getImagem())){ //se a imagem for diferente, atualizamos
						this.bebidas.get(i).setImagem(bebida.getImagem());
					}	
				}
			}
			
			return true;
		}

		return false;
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
