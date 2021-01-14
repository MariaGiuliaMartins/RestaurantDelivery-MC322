package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Restaurante extends javax.swing.JPanel{
	JPanel Restaurante = new JPanel();
	public Restaurante() {
        initComponents();
    }

//
	@SuppressWarnings("deprecation")
	private void initComponents() {
		JFrame frameRestaurante = new JFrame("Restaurante");
		frameRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//------------------------------------------ADMINISTRADORES------------------------------------
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new JMenu("Administradores"));
			
		JTextField nomeAdmin = new JTextField(12);
		JLabel labelNomeAdmin = new JLabel("Nome do Administrador: ");
		labelNomeAdmin.setLabelFor(nomeAdmin);
				
		JTextField cpfAdmin = new JTextField(12);
		JLabel labelCpfAdmin = new JLabel("CPF do Administrador: ");
		labelCpfAdmin.setLabelFor(cpfAdmin);
		
		JTextField emailAdmin = new JTextField(12);
		JLabel labelEmailAdmin = new JLabel("Email do Administrador: ");
		labelEmailAdmin.setLabelFor(emailAdmin);
		
		JTextField telAdmin = new JTextField(12);
		JLabel labelTelAdmin = new JLabel("Telefone do Administrador: ");
		labelTelAdmin.setLabelFor(telAdmin);
		
		JTextField statusAdmin = new JTextField(12);
		JLabel labelStatusAdmin = new JLabel("Status do Administrador: ");
		labelStatusAdmin.setLabelFor(statusAdmin);
		
		/*JButton botaoAdmin = new JButton("Adicionar Administrador");
		menuBar.add(botaoAdmin);
		botaoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAdminActionPerformed(evt);
            }

			private void jButtonAddAdminActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });*/
		
		
		
		

//------------------------------------------FUNCIONÁRIOS------------------------------------		
		
		menuBar.add(new JMenu("Funcionários"));
		
		JTextField nomeFunc = new JTextField(12);
		JLabel labelNomeFunc = new JLabel("Nome do Funcionário: ");
		labelNomeFunc.setLabelFor(nomeFunc);
		
		JTextField cpfFunc = new JTextField(12);
		JLabel labelCpfFunc = new JLabel("CPF do Funcionário: ");
		labelCpfFunc.setLabelFor(cpfFunc);
		
		JTextField emailFunc = new JTextField(12);
		JLabel labelEmailFunc = new JLabel("Email do Funcionário: ");
		labelEmailFunc.setLabelFor(emailFunc);
		
		JTextField telFunc = new JTextField(12);
		JLabel labelTelFunc = new JLabel("Telefone do Funcionário: ");
		labelTelFunc.setLabelFor(telFunc);
		
		JTextField statusFunc = new JTextField(12);
		JLabel labelStatusFunc = new JLabel("Status do Funcionário: ");
		labelStatusFunc.setLabelFor(statusFunc);
		
		/*JButton botaoFunc = new JButton("Adicionar Fucnionário");
		menuBar.add(botaoFunc);
		botaoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFuncActionPerformed(evt);
            }

			private void jButtonAddFuncActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });*/
		
		
		
//------------------------------------------ENTREGADORES------------------------------------
		
		menuBar.add(new JMenu("Entregadores"));
		
		JTextField nomeEntregadores = new JTextField(12);
		JLabel labelNomeEntregadores = new JLabel("Nome do Entregador: ");
		labelNomeEntregadores.setLabelFor(nomeEntregadores);
		
		JTextField cpfEntregadores = new JTextField(12);
		JLabel labelCpfEntregadores = new JLabel("CPF do Entregador: ");
		labelCpfEntregadores.setLabelFor(cpfEntregadores);
		
		JTextField emailEntregadores = new JTextField(12);
		JLabel labelEmailEntregadores = new JLabel("Email do Entregador: ");
		labelEmailEntregadores.setLabelFor(emailEntregadores);
		
		JTextField telEntregadores = new JTextField(12);
		JLabel labelTelEntregadores = new JLabel("Telefone do Entregador: ");
		labelTelEntregadores.setLabelFor(telEntregadores);
		
		JTextField statusEntregadores = new JTextField(12);
		JLabel labelStatusEntregadores = new JLabel("Status do Entregador: ");
		labelStatusEntregadores.setLabelFor(statusEntregadores);
		
		/*JButton botaoEntregadores = new JButton("Adicionar Entregador");
		menuBar.add(botaoEntregadores);
		botaoEntregadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEntregadoresActionPerformed(evt);
            }

			private void jButtonAddEntregadoresActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });*/
		
		
		
//------------------------------------------PEDIDOS------------------------------------
		
		menuBar.add(new JMenu("Pedidos"));
		
		JTextField nomeCliente = new JTextField(12);
		JLabel labelNomeCliente = new JLabel("Nome do Cliente: ");
		labelNomeCliente.setLabelFor(nomeCliente);
		
		JTextField valorPedido = new JTextField(12);
		JLabel labelvalorPedido = new JLabel("Valor do Pedido: ");
		labelvalorPedido.setLabelFor(valorPedido);
		
		JTextField metodoPagamento = new JTextField(12);
		JLabel labelMetodoPagamento = new JLabel("Método de Pagamento: ");
		labelMetodoPagamento.setLabelFor(metodoPagamento);
		
		JTextField statusPedido = new JTextField(12);
		JLabel labelStatusPedido= new JLabel("Status do Pedido: ");
		labelStatusPedido.setLabelFor(statusPedido);
		
		/*JButton botaoPedido = new JButton("Adicionar Pedido");
		menuBar.add(botaoPedido);
		botaoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPedidoActionPerformed(evt);
            }

			private void jButtonAddPedidoActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });*/
	
		
		frameRestaurante.setJMenuBar(menuBar);
		frameRestaurante.pack();
		frameRestaurante.show();
	}
	
}
