package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;

public class Pedido extends javax.swing.JPanel {

    private CardapioController cardapioController;
    private FuncionarioController funcionarioController;
    private ClienteController clienteController;
    private EntregadorController entregadorController;
    private PedidoController pedidoController;

    private Cliente cliente;
    private Funcionario funcionario;
    private Entregador entregador;
    private ArrayList<ItemCardapio> itensPedido;

    public Pedido(CardapioController cardapioController, EntregadorController entregadorController, ClienteController clienteController, FuncionarioController funcionarioController, PedidoController pedidoController) {
        this.cardapioController = cardapioController;
        this.funcionarioController = funcionarioController;
        this.entregadorController = entregadorController;
        this.clienteController = clienteController;
        this.pedidoController = pedidoController;
        this.itensPedido = new ArrayList<ItemCardapio>();
        initComponents();
    }

    private void initComponents() {

        jScrollPaneComidas = new javax.swing.JScrollPane();
        jListComidas = new javax.swing.JList<Comida>();
        jLabelBebidas = new javax.swing.JLabel();
        jLabelComidas = new javax.swing.JLabel();
        jScrollPaneBebidas = new javax.swing.JScrollPane();
        jListBebidas = new javax.swing.JList<>();
        jButtonAddComida = new javax.swing.JButton();
        jButtonAddBebida = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalValue = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jLabelTotalCurrency = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelClienteValue = new javax.swing.JLabel();
        jButtonSelectClient = new javax.swing.JButton();
        jButtonSelectFunc = new javax.swing.JButton();
        jLabelFuncionario = new javax.swing.JLabel();
        jLabelFuncionarioValue = new javax.swing.JLabel();
        jScrollPanePedido = new javax.swing.JScrollPane();
        jListPedidos = new javax.swing.JList<>();
        jLabelPedido = new javax.swing.JLabel();
        jLabelEntregador = new javax.swing.JLabel();
        jLabelEntregadorValue = new javax.swing.JLabel();
        jButtonSelectEntregador = new javax.swing.JButton();

        //Setting up list of comidas
        jListModelComidas = new DefaultListModel<Comida>();
        jListComidas.setModel(jListModelComidas);
        for (Comida comida : cardapioController.getComidas()){
            jListModelComidas.addElement(comida);
        }
        jScrollPaneComidas.setViewportView(jListComidas);

        jLabelBebidas.setText("Bebidas");

        jLabelComidas.setText("Comidas");

        //Setting up list of bebidas
        jListModelBebidas = new DefaultListModel<Bebida>();
        jListBebidas.setModel(jListModelBebidas);
        for (Bebida bebida : cardapioController.getBebidas()){
            jListModelBebidas.addElement(bebida);
        }
        jScrollPaneBebidas.setViewportView(jListBebidas);

        // Setting up pedido
        jListModelPedidos = new DefaultListModel<ItemCardapio>();
        jListPedidos.setModel(jListModelPedidos);
        jScrollPanePedido.setViewportView(jListPedidos);

        jLabelPedido.setText("Pedido");

        jButtonAddComida.setText("Adicionar Comida");
        jButtonAddComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddComidaActionPerformed(evt);
            }
        });

        jButtonAddBebida.setText("Adicionar Bebida");
        jButtonAddBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBebidaActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover Item");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar Cardapio");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jLabelTotal.setText("Total:");

        jLabelTotalValue.setText("0");

        jButtonLimpar.setText("Limpar Pedido");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText("Finalizar Pedido");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jLabelTotalCurrency.setText("R$");

        jLabelCliente.setText("Cliente:");

        jButtonSelectClient.setText("Selecionar Cliente");
        jButtonSelectClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectClientActionPerformed(evt);
            }
        });

        jButtonSelectFunc.setText("Selecionar Funcionario");
        jButtonSelectFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFuncActionPerformed(evt);
            }
        });

        jLabelFuncionario.setText("Funcionario:");

        jLabelEntregador.setText("Entregador:");

        jLabelEntregadorValue.setText("");

        jButtonSelectEntregador.setText("Selecionar Entregador");
        jButtonSelectEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectEntregadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelTotal)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabelTotalValue)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabelTotalCurrency))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPaneComidas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPaneBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPanePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 33, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonAddComida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                                        .addComponent(jButtonAddBebida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelFuncionario)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabelFuncionarioValue))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelCliente)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabelClienteValue))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelEntregador)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabelEntregadorValue)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonSelectEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jButtonSelectClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButtonSelectFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCliente)
                                        .addComponent(jLabelClienteValue)
                                        .addComponent(jButtonSelectClient))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFuncionario)
                                        .addComponent(jButtonSelectFunc)
                                        .addComponent(jLabelFuncionarioValue))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEntregador)
                                        .addComponent(jLabelEntregadorValue)
                                        .addComponent(jButtonSelectEntregador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelBebidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonAddComida)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonAddBebida)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRemover)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonAtualizar)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPaneComidas, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneBebidas)
                                        .addComponent(jScrollPanePedido, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTotal)
                                        .addComponent(jLabelTotalValue)
                                        .addComponent(jButtonLimpar)
                                        .addComponent(jButtonFinalizar)
                                        .addComponent(jLabelTotalCurrency))
                                .addContainerGap())
        );
    }// </editor-fold>

    private void jButtonAddComidaActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jListComidas.getSelectedIndex();
        if (index < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma comida");
            return;
        }
        ItemCardapio comida = (ItemCardapio) jListModelComidas.getElementAt(index);
        Double total = Double.valueOf(jLabelTotalValue.getText());
        total += comida.getPreco();
        jLabelTotalValue.setText(total.toString());
        jListModelPedidos.addElement(comida);
        itensPedido.add(comida);
    }

    private void jButtonAddBebidaActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jListBebidas.getSelectedIndex();
        if (index < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma bebida");
            return;
        }
        ItemCardapio bebida = (ItemCardapio) jListModelBebidas.getElementAt(index);
        Double total = Double.valueOf(jLabelTotalValue.getText());
        total += bebida.getPreco();
        jLabelTotalValue.setText(total.toString());
        jListModelPedidos.addElement(bebida);
        itensPedido.add(bebida);
    }

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jListPedidos.getSelectedIndex();
        if (index < 0){
            JOptionPane.showMessageDialog(null, "Selecione um item do pedido");
            return;
        }
        jListModelPedidos.remove(index);
        itensPedido.remove(index);
    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        Double zero = 0.0;
        jLabelTotalValue.setText(zero.toString());
        jListModelPedidos.removeAllElements();
        itensPedido.clear();
    }

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        // Atualiza cardapio
        jListModelBebidas.removeAllElements();
        jListModelComidas.removeAllElements();
        for (Bebida bebida : cardapioController.getBebidas()){
            jListModelBebidas.addElement(bebida);
        }
        jScrollPaneBebidas.setViewportView(jListBebidas);

        for (Comida comida : cardapioController.getComidas()){
            jListModelComidas.addElement(comida);
        }
        jScrollPaneComidas.setViewportView(jListComidas);
    }

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.cliente == null || this.entregador == null || this.funcionario == null || this.itensPedido.size() == 0){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }
        pedidoController.addPedido(this.cliente, this.itensPedido, this.funcionario, this.entregador);
        JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso");
        // Limpa os campos
        this.cliente = null;
        jLabelClienteValue.setText("");
        jLabelTotalValue.setText("0.0");
        this.itensPedido.clear();
        jListModelPedidos.clear();
    }

    private void jButtonSelectClientActionPerformed(java.awt.event.ActionEvent evt) {
        if (clienteController.getClientes().size() == 0) {
            return;
        }
        Cliente[] clientes = new Cliente[clienteController.getClientes().size()];
        int i = 0;
        for (Cliente cliente : clienteController.getClientes()){
            clientes[i] = cliente;
            i++;
        }
        Cliente cliente = (Cliente) JOptionPane.showInputDialog(null, "Selecione um cliente", "Clientes", JOptionPane.QUESTION_MESSAGE,
                null, clientes, clientes[0]);

        if (cliente == null)
            return;
        jLabelClienteValue.setText(cliente.toString());
        this.cliente = cliente;

    }

    private void jButtonSelectFuncActionPerformed(java.awt.event.ActionEvent evt) {
        if (funcionarioController.getFuncionarios().size() == 0) {
            return;
        }
        Funcionario[] funcionarios = new Funcionario[funcionarioController.getFuncionarios().size()];
        int i = 0;
        for (Funcionario funcionario : funcionarioController.getFuncionarios()){
            funcionarios[i] = funcionario;
            i++;
        }
        Funcionario funcionario = (Funcionario) JOptionPane.showInputDialog(null, "Selecione um funcionario", "Funcionarios", JOptionPane.QUESTION_MESSAGE,
                null, funcionarios, funcionarios[0]);

        if (funcionario == null)
            return;

        jLabelFuncionarioValue.setText(funcionario.toString());
        this.funcionario = funcionario;
    }

    private void jButtonSelectEntregadorActionPerformed(java.awt.event.ActionEvent evt) {
        if (entregadorController.getEntregadores().size() == 0) {
            return;
        }
        Entregador[] entregadores = new Entregador[entregadorController.getEntregadores().size()];
        int i = 0;
        for (Entregador entregador : entregadorController.getEntregadores()){
            entregadores[i] = entregador;
            i++;
        }
        Entregador entregador = (Entregador) JOptionPane.showInputDialog(null, "Selecione um entregador", "Entregadores", JOptionPane.QUESTION_MESSAGE,
                null, entregadores, entregadores[0]);

        if (entregador == null)
            return;

        jLabelEntregadorValue.setText(entregador.toString());
        this.entregador = entregador;
    }

    private javax.swing.JButton jButtonAddBebida;
    private javax.swing.JButton jButtonAddComida;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSelectClient;
    private javax.swing.JButton jButtonSelectEntregador;
    private javax.swing.JButton jButtonSelectFunc;
    private javax.swing.JLabel jLabelBebidas;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelClienteValue;
    private javax.swing.JLabel jLabelComidas;
    private javax.swing.JLabel jLabelEntregador;
    private javax.swing.JLabel jLabelEntregadorValue;
    private javax.swing.JLabel jLabelFuncionario;
    private javax.swing.JLabel jLabelFuncionarioValue;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalCurrency;
    private javax.swing.JLabel jLabelTotalValue;
    private javax.swing.JList<String> jListBebidas;
    private JList<Comida> jListComidas;
    private javax.swing.JList<String> jListPedidos;
    private javax.swing.JScrollPane jScrollPaneBebidas;
    private javax.swing.JScrollPane jScrollPaneComidas;
    private javax.swing.JScrollPane jScrollPanePedido;
    private DefaultListModel jListModelComidas;
    private DefaultListModel jListModelBebidas;
    private DefaultListModel jListModelPedidos;
}
