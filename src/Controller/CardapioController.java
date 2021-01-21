package Controller;

import Model.Bebida;
import Model.Cardapio;
import Model.Comida;
import Model.ItemCardapio;

import java.io.*;

public class CardapioController {

    private Cardapio cardapio;

    public CardapioController(Cardapio cardapio){

        this.cardapio = cardapio;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/bebidas.txt"));
            while(true){
                Bebida bebida = (Bebida) input.readObject();
                this.cardapio.criarItemCardapio(bebida);
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/comidas.txt"));
            while(true){
                Comida comida = (Comida) input.readObject();
                this.cardapio.criarItemCardapio(comida);
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save(){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/bebidas.txt"));
            for(Bebida bebida : this.cardapio.getBebida() ){
                output.writeObject(bebida);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/comidas.txt"));
            for(Comida comida : this.cardapio.getComida() ){
                output.writeObject(comida);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addItem(Comida item){
        this.cardapio.criarItemCardapio(item);
    }

    public void addItem(Bebida item){
        this.cardapio.criarItemCardapio(item);
    }

    public void remove(Comida item){
        this.cardapio.removerItemCardapio(item);
    }

    public void remove(Bebida item){
        this.cardapio.removerItemCardapio(item);
    }
}
