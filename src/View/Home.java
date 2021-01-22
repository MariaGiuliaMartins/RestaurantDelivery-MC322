package View;

import Controller.*;
import Model.Entregador;

import java.util.ArrayList;

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
    }
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelPedidos = new Pedido(cardapioController, entregadorController, clienteController, funcionarioController, pedidoController);
        jPanelCardapio = new Cardapio(cardapioController);
        jPanelAdmin = new Clientes(clienteController);
        jPanelEntregadores = new Entregadores(entregadorController);
        jPanelFuncionarios = new Funcionarios(funcionarioController);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPanelHomeLayout.setVerticalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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

    private javax.swing.JPanel jPanelHome;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Pedido jPanelPedidos;
    private Cardapio jPanelCardapio;
    private Clientes jPanelAdmin;
    private Funcionarios jPanelFuncionarios;
    private Entregadores jPanelEntregadores;
}
