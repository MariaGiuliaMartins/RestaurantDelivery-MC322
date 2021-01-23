package View;

import Controller.*;
import Model.Entregador;
import helpers.TableMouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Home extends javax.swing.JFrame {

    private Model.Cardapio cardapio;
    private Controller.CardapioController cardapioController;

    private ArrayList<Model.Funcionario> funcionarios;
    private Controller.FuncionarioController funcionarioController;

    private ArrayList<Model.Cliente> clientes;
    private Controller.ClienteController clienteController;

    private ArrayList<Model.Entregador> entregadores;
    private Controller.EntregadorController entregadorController;

    private ArrayList<Model.Pedido> pedidos;
    private Controller.PedidoController pedidoController;

    private String[] columnNames = new String[] {"ID", "Data", "Cliente", "Itens pedidos","Preço (R$)", "Funcionario", "Entregador"};

    public Home() {

        cardapio = new Model.Cardapio();
        cardapioController = new CardapioController(cardapio);

        funcionarios = new ArrayList<Model.Funcionario>();
        funcionarioController = new FuncionarioController(funcionarios);

        clientes = new ArrayList<Model.Cliente>();
        clienteController = new ClienteController(clientes);

        entregadores = new ArrayList<Entregador>();
        entregadorController = new EntregadorController(entregadores);

        pedidos = new ArrayList<Model.Pedido>();
        pedidoController = new PedidoController(pedidos);

        initComponents();

        //Close opereations
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int i=JOptionPane.showConfirmDialog(null, "Tem certeza em fechar o programa ?");
                if(i==0)
                    saveFiles();
                    System.exit(0);
            }
        });
    }
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPedidos = new Pedido(cardapioController, entregadorController, clienteController, funcionarioController, pedidoController);
        jPanelCardapio = new Cardapio(cardapioController);
        jPanelAdmin = new Clientes(clienteController);
        jPanelEntregadores = new Entregadores(entregadorController);
        jPanelFuncionarios = new Funcionarios(funcionarioController);
        jButtonAtualizar = new javax.swing.JButton();

        setSize(new java.awt.Dimension(800, 500));

        // comida table
        List<String[]> rowData = new ArrayList<String[]>();

        for (Model.Pedido pedido : pedidoController.getPedidos()){
            String[] aux = {String.valueOf(pedido.getId()), pedido.getDataCriacao().toString(),pedido.getCliente().toString(), pedido.getItensPedidos().toString(),String.valueOf(pedido.getValor()), pedido.getResponsavel().toString(), pedido.getEntregador().toString()};
            rowData.add(aux);
        }

        String[][] arrayPedidos = new String[ rowData.size() ][];
        rowData.toArray( arrayPedidos );
        // constructs the table with sample data
        tableModelPedidos = new DefaultTableModel(arrayPedidos, columnNames);
        jTablePedidos = new javax.swing.JTable(tableModelPedidos);

        jScrollPane1.setViewportView(jTablePedidos);

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        //Setting popmenu
        popupMenu = new JPopupMenu();
        menuItemRemove = new JMenuItem("Remove Pedido");
        menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePedido(evt);
            }
        });
        popupMenu.add(menuItemRemove);
        jTablePedidos.setComponentPopupMenu(popupMenu);
        jTablePedidos.addMouseListener(new TableMouseListener(jTablePedidos));


        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                        .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAtualizar))
        );
        jPanelHomeLayout.setVerticalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanelHome);
        jTabbedPane1.addTab("Pedidos", jPanelHome);
        jTabbedPane1.addTab("Fazer Pedido", jPanelPedidos);
        jTabbedPane1.addTab("Cardapio", jPanelCardapio);
        jTabbedPane1.addTab("Clientes", jPanelAdmin);
        jTabbedPane1.addTab("Funcionarios", jPanelFuncionarios);
        jTabbedPane1.add("Entregadores", jPanelEntregadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        //Clear
        while (tableModelPedidos.getRowCount() > 0){
            for (int i = 0; i < tableModelPedidos.getRowCount(); ++i){
                tableModelPedidos.removeRow(i);
            }
        }
        for (Model.Pedido pedido : pedidoController.getPedidos()){
            String[] aux = {String.valueOf(pedido.getId()), pedido.getDataCriacao().toString(),pedido.getCliente().toString(), pedido.getItensPedidos().toString(),String.valueOf(pedido.getValor()), pedido.getResponsavel().toString(), pedido.getEntregador().toString()};
            tableModelPedidos.addRow(aux);
        }
    }


    private void removePedido(java.awt.event.ActionEvent evt) {
        int selectedRow = jTablePedidos.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Selecione um pedido");
            return;
        }
        tableModelPedidos.removeRow(selectedRow);
        pedidoController.removePedido(selectedRow);
    }

    private void saveFiles(){
        pedidoController.save();
        clienteController.save();
        funcionarioController.save();
        entregadorController.save();
    }

    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedidos;
    private DefaultTableModel tableModelPedidos;
    private JMenuItem menuItemRemove;
    private JPopupMenu popupMenu;
    private Pedido jPanelPedidos;
    private Cardapio jPanelCardapio;
    private Clientes jPanelAdmin;
    private Funcionarios jPanelFuncionarios;
    private Entregadores jPanelEntregadores;
}
