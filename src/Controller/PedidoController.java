package Controller;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class PedidoController {

    private ArrayList<Pedido> pedidos;

    public PedidoController(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/pedidos.txt"));
            while(true){
                Pedido pedido = (Pedido) input.readObject();
                this.pedidos.add(pedido);
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Usuario cliente, ArrayList<ItemCardapio> itens, Usuario responsavel, Entregador entregador){
        Pedido pedido = new Pedido (Calendar.getInstance(), cliente, itens, responsavel, entregador);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/pedidos.txt"));
            output.writeObject(pedido);
            output.flush();
            output.close();
            pedidos.add(pedido);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removePedido(int index){
        this.pedidos.remove(index);
    }
}
