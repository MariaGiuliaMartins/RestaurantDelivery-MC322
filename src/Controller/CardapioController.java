package Controller;

import Model.Bebida;
import Model.Cardapio;
import Model.Comida;

import java.io.*;
import java.util.ArrayList;

public class CardapioController {

    private Cardapio cardapio;

    public CardapioController(Cardapio cardapio){

        this.cardapio = cardapio;

        // Serializa dados no objeto
        try {
            FileInputStream fi = new FileInputStream("src/data/bebidas.txt");
            try {
                ObjectInputStream input = new ObjectInputStream(fi);
                try {
                    while (true) {
                        Bebida bebida = (Bebida) input.readObject();
                        this.cardapio.criarItemCardapio(bebida);
                    }
                } finally {
                    input.close();
                }

            } finally {
                fi.close();
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
        try {

            FileInputStream fi = new FileInputStream("src/data/comidas.txt");
            try {
                ObjectInputStream input = new ObjectInputStream(fi);
                try {
                    while (true) {
                        Comida comida = (Comida) input.readObject();
                        this.cardapio.criarItemCardapio(comida);
                    }
                } finally {
                    input.close();
                }

            } finally {
                fi.close();
            }

        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Comida> getComidas(){
        return this.cardapio.getComida();
    }

    public ArrayList<Bebida> getBebidas(){
        return this.cardapio.getBebida();
    }

    public void addItem(Comida item){
        this.cardapio.criarItemCardapio(item);
    }

    public void addItem(Bebida item){
        this.cardapio.criarItemCardapio(item);
    }

    // Reseta lista de comida e bebida do cardapio pra poder dar overwrite no arquivo
    public void reset(){
        this.cardapio.getComida().clear();
        this.cardapio.getBebida().clear();
    }

    public void save(){

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/bebidas.txt"));
            for(Bebida bebida : this.cardapio.getBebida() ){
                output.writeObject(bebida);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/comidas.txt"));
            for(Comida comida : this.cardapio.getComida() ){
                output.writeObject(comida);
            }
            output.flush();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
