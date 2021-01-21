package View;

import Model.Restaurante;

public class Pedido extends javax.swing.JPanel {

    private Restaurante restaurante;


    public Pedido(Restaurante restaurante) {
        initComponents();
        this.restaurante = restaurante;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPaneComidas = new javax.swing.JScrollPane();
        jListComidas = new javax.swing.JList<>();
        jLabelBebidas = new javax.swing.JLabel();
        jLabelComidas = new javax.swing.JLabel();
        jScrollPaneBebidas = new javax.swing.JScrollPane();
        jListBebidas = new javax.swing.JList<>();
        jButtonAddComida = new javax.swing.JButton();
        jButtonAddBebida = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
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

        jListComidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneComidas.setViewportView(jListComidas);

        jLabelBebidas.setText("Bebidas");

        jLabelComidas.setText("Comidas");

        jListBebidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneBebidas.setViewportView(jListBebidas);

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

        jListPedidos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPanePedido.setViewportView(jListPedidos);

        jLabelPedido.setText("Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelFuncionario)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabelFuncionarioValue))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelCliente)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabelClienteValue)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonSelectClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonSelectFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonAddComida)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonAddBebida)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRemover)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPaneComidas, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneBebidas)
                                        .addComponent(jScrollPanePedido, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
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
        // TODO add your handling code here:
    }

    private void jButtonAddBebidaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonSelectClientActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonSelectFuncActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JButton jButtonAddBebida;
    private javax.swing.JButton jButtonAddComida;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSelectClient;
    private javax.swing.JButton jButtonSelectFunc;
    private javax.swing.JLabel jLabelBebidas;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelClienteValue;
    private javax.swing.JLabel jLabelComidas;
    private javax.swing.JLabel jLabelFuncionario;
    private javax.swing.JLabel jLabelFuncionarioValue;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalCurrency;
    private javax.swing.JLabel jLabelTotalValue;
    private javax.swing.JList<String> jListBebidas;
    private javax.swing.JList<String> jListComidas;
    private javax.swing.JList<String> jListPedidos;
    private javax.swing.JScrollPane jScrollPaneBebidas;
    private javax.swing.JScrollPane jScrollPaneComidas;
    private javax.swing.JScrollPane jScrollPanePedido;
}
