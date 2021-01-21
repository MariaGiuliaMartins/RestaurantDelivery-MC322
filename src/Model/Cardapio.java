package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cardapio {
	//atributos
	private ArrayList<Comida> comidas;
	private ArrayList<Bebida> bebidas;
	
	//construtor
	public Cardapio(){
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
		* Função que adiciona uma comida no cardapio
		* Input: um item de comida, usuario que adicionará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean criarItemCardapio(Comida comida) {
		int auxComida = Collections.frequency(this.comidas, comida); //auxiliar para contadora de comida

		if(auxComida == 0) { //se a auxiliar de comida for 0, então essa comida não existe no cardapio
			this.comidas.add(comida); //então adicionamos
			System.out.println("Models.Comida adicionada com sucesso!");
		}

		return true;
	}

	///criar item do cardápio
	/*
		* Função que adiciona uma bebida no cardapio
		* Input: um item de bebida, usuario que adicionará o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean criarItemCardapio(Bebida bebida) {
		//vamos fazer a mesma coisa para a bebida
		int auxBebida = Collections.frequency(this.bebidas, bebida); //auxiliar contadora de bebida

		if(auxBebida == 0) { //se a auxilar de bebida não incrementar, então essa bebida não existe no cardapio
			this.bebidas.add(bebida); //então adicionamos
			System.out.println("Models.Bebida adicionada com sucesso!");
		}

		return true;
	}
	
	///remover item do cardápio
	/*
		* Função que remove uma comida do cardapio
		* Input: um item de comida, usuario que removerá o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean removerItemCardapio(Comida comida) {
		//agora vemos se a comida existe
		if (this.comidas.contains(comida)) {
			this.comidas.remove(comida);
			System.out.println("Models.Comida removida com sucesso!");
		}

		return true;
	}

	///remover item do cardápio
	/*
		* Função que remove uma bebida do cardapio
		* Input: um item de bebida, usuario que removerá o alimento
		* Output: boolean - true significa sucesso, false significa que algo de errado ocorreu
	*/
	public boolean removerItemCardapio(Bebida bebida) {
		//verificamos se a bebida existe no cardápio
		if (this.bebidas.contains(bebida)) {
			this.bebidas.remove(bebida);
			System.out.println("Models.Bebida removida com sucesso!");
		}

		return true;
	}
	
	///toString
	@Override
	public String toString() {
		String out = "Comidas do Cardápio: \n";
		for(int i = 0; i < this.comidas.size(); i++) {
			out += "-- Models.Comida " + i + ":";
			out += "Nome: " + this.comidas.get(i).getNome() + ", ";
			out += "Descrição: " + this.comidas.get(i).getDescricao() + ", ";
			out += "Preço: " + this.comidas.get(i).getPreco() + ", ";
			out += "Imagem: " + this.comidas.get(i).getImagem() + ";"+  "\n";
		}
		out += "\n";
		out = "Bebidas do Cardápio: \n";
		for(int i = 0; i < this.bebidas.size(); i++) {
			out += "-- Models.Bebida " + i + ":";
			out += "Nome: " + this.bebidas.get(i).getNome() + ", ";
			out += "Descrição: " + this.bebidas.get(i).getDescricao() + ", ";
			out += "Preço: " + this.bebidas.get(i).getPreco() + ", ";
			out += "Imagem: " + this.bebidas.get(i).getImagem() + ";"+  "\n";
		}
		return out;
	}
}
