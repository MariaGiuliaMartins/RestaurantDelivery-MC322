package Controller;

import Model.Bebida;
import Model.Comida;
import Model.Pedido;
import Model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class PedidoController {

    private ArrayList<Pedido> pedidos;

    public PedidoController(){
        this.pedidos = new ArrayList<Pedido>();

        // Serializa dados no objeto
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/data/pedidos.txt"));
            while(true){
                Pedido pedido = (Pedido) input.readObject();
                this.pedidos.add(pedido);
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void criarPedido(Calendar dataCriacao, Usuario cliente, ArrayList<Comida> comidas, ArrayList<Bebida> bebidas, Usuario responsavel)
    {
        Pedido pedido_novo = new Pedido(dataCriacao, cliente, comidas, bebidas, responsavel);
        this.pedidos.add(pedido_novo);
        save();
    }

    public void save() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/pedidos.txt"));
            for(Pedido pedido : this.pedidos ){
                output.writeObject(pedido);
            }
            output.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
