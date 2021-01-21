package View;

public class Home extends javax.swing.JFrame {

    private Model.Cardapio cardapio;

    public Home() {
        cardapio = new Model.Cardapio();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelPedidos = new Pedido();
        jPanelCardapio = new Cardapio();
        jPanelAdmin = new Admin();
        jPanelEntregadores = new Entregadores();
        jPanelFuncionarios = new Funcionarios();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("Bem-vindo");

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeLayout.createSequentialGroup()
                                .addContainerGap(198, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(193, 193, 193))
        );
        jPanelHomeLayout.setVerticalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel1)
                                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanelHome);
        jTabbedPane1.addTab("Pedidos", jPanelPedidos);
        jTabbedPane1.addTab("Cardapio", jPanelCardapio);
        jTabbedPane1.addTab("Admin", jPanelAdmin);
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


    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JTabbedPane jTabbedPane1;
    private Pedido jPanelPedidos;
    private Cardapio jPanelCardapio;
    private Admin jPanelAdmin;
    private Funcionarios jPanelFuncionarios;
    private Entregadores jPanelEntregadores;
}
