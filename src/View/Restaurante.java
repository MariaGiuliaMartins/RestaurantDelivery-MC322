package View;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		//JTabbedPane restaurante = new javax.swing.JTabbedPane();
//------------------------------------------ADMINISTRADORES------------------------------------
				
		JPanel adm = new javax.swing.JPanel();
		frameRestaurante.add("Administradores", adm);
				
		
		JLabel labelNomeAdmin = new JLabel();
		labelNomeAdmin.setText("Nome do Administrador: ");
		JTextField nomeAdmin = new JTextField();
		
		JLabel labelCpfAdmin = new JLabel();
		labelCpfAdmin.setText("CPF do Administrador: ");
		JTextField cpfAdmin = new JTextField();
		
		JLabel labelEmailAdmin = new JLabel();
		labelEmailAdmin.setText("Email do Administrador: ");
		JTextField emailAdmin = new JTextField();
		
		JLabel labelTelAdmin = new JLabel();
		labelTelAdmin.setText("Telefone do Administrador: ");
		JTextField telAdmin = new JTextField();
		
		JLabel labelStatusAdmin = new JLabel();
		labelStatusAdmin.setText("Status do Administrador: ");
		JTextField statusAdmin = new JTextField();
		
		JButton botaoAdmin = new JButton("Adicionar Administrador");
		adm.add(botaoAdmin);
		botaoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAdminActionPerformed(evt);
            }

			private void jButtonAddAdminActionPerformed(ActionEvent evt) {
				//manipulando o arquivo referente aos admins
				String filename = "data/administradores.txt";
				try {
					Formatter output = new Formatter(filename);
					//nome, cpf, email, telefone e status
					output.format("%s %s %s %s %s %s %d\n", nomeAdmin, cpfAdmin, emailAdmin, telAdmin, statusAdmin);
					output.flush();
					output.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}				
			}
        });
		
		javax.swing.GroupLayout admLayout = new javax.swing.GroupLayout(adm);
		adm.setLayout(admLayout);
		  admLayout.setHorizontalGroup(
		      admLayout.createParallelGroup
		      (javax.swing.GroupLayout.Alignment.LEADING)
		      .addGroup(admLayout.createSequentialGroup()
		          .addContainerGap()
		          .addGroup(admLayout.createParallelGroup
		          (javax.swing.GroupLayout.Alignment.LEADING)
		              .addComponent(nomeAdmin, javax.swing
		              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
		              .GroupLayout.PREFERRED_SIZE)
		              .addComponent(nomeAdmin))
		          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  admLayout.setHorizontalGroup(
			      admLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(admLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(admLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(cpfAdmin, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(cpfAdmin))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  admLayout.setHorizontalGroup(
			      admLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(admLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(admLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(emailAdmin, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(emailAdmin))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  admLayout.setHorizontalGroup(
			      admLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(admLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(admLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(telAdmin, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(telAdmin))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  admLayout.setHorizontalGroup(
			      admLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(admLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(admLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(statusAdmin, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(statusAdmin))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );

//------------------------------------------FUNCIONÁRIOS------------------------------------		
		
		JPanel func = new javax.swing.JPanel();
		frameRestaurante.add("Fucionários", func);
				
		JLabel labelNomeFunc = new JLabel();
		labelNomeFunc.setText("Nome do Funcionário: ");
		JTextField nomeFunc = new JTextField();
		
		JLabel labelCpfFunc = new JLabel();
		labelCpfFunc.setText("CPF do Funcionário: ");
		JTextField cpfFunc = new JTextField();
		
		JLabel labelEmailFunc = new JLabel();
		labelEmailFunc.setText("Email do Funcionário: ");
		JTextField emailFunc = new JTextField();
		
		JLabel labelTelFunc = new JLabel();
		labelTelFunc.setText("Telefone do Funcionário: ");
		JTextField telFunc = new JTextField();
		
		JLabel labelStatusFunc = new JLabel();
		labelStatusFunc.setText("Status do Funcionário: ");
		JTextField statusFunc = new JTextField();
		
		JButton botaoFunc = new JButton("Adicionar Fucnionário");
		func.add(botaoFunc);
		botaoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFuncActionPerformed(evt);
            }

			private void jButtonAddFuncActionPerformed(ActionEvent evt) {
				//manipulando o arquivo referente aos funcionarios
				String filename = "data/funcionarios.txt";
				try {
					Formatter output = new Formatter(filename);
					//nome, cpf, email, telefone e status
					output.format("%s %s %s %s %s %s %d\n", nomeFunc, cpfFunc, emailFunc, telFunc, statusFunc);
					output.flush();
					output.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
        });
		
		javax.swing.GroupLayout funcLayout = new javax.swing.GroupLayout(func);
		func.setLayout(funcLayout);
		  funcLayout.setHorizontalGroup(
		      funcLayout.createParallelGroup
		      (javax.swing.GroupLayout.Alignment.LEADING)
		      .addGroup(funcLayout.createSequentialGroup()
		          .addContainerGap()
		          .addGroup(funcLayout.createParallelGroup
		          (javax.swing.GroupLayout.Alignment.LEADING)
		              .addComponent(nomeFunc, javax.swing
		              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
		              .GroupLayout.PREFERRED_SIZE)
		              .addComponent(nomeFunc))
		          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  funcLayout.setHorizontalGroup(
				  funcLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(funcLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(funcLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(cpfFunc, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(cpfFunc))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  funcLayout.setHorizontalGroup(
			      funcLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(funcLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(funcLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(emailFunc, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(emailFunc))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  funcLayout.setHorizontalGroup(
			      funcLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(funcLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(funcLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(telFunc, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(telFunc))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  funcLayout.setHorizontalGroup(
			      funcLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(funcLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(funcLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(statusFunc, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(statusFunc))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		
		
//------------------------------------------ENTREGADORES------------------------------------
		
		JPanel ent = new javax.swing.JPanel();
		frameRestaurante.add("Entregadores", ent);
		
		JLabel labelNomeEntregadores = new JLabel();
		labelNomeEntregadores.setText("Nome do Entregador: ");
		JTextField nomeEnt = new JTextField();
		
		JLabel labelCpfEntregadores = new JLabel();
		labelCpfEntregadores.setText("CPF do Entregador: ");
		JTextField cpfEnt = new JTextField();
		
		JLabel labelEmailEntregadores = new JLabel();
		labelEmailEntregadores.setText("Email do Entregador: ");
		JTextField emailEnt = new JTextField();
		
		JLabel labelTelEntregadores = new JLabel();
		labelTelEntregadores.setText("Telefone do Entregador: ");
		JTextField telEnt = new JTextField();
		
		JLabel labelStatusEntregadores = new JLabel();
		labelStatusEntregadores.setText("Status do Entregador: ");
		JTextField statusEnt = new JTextField();
		
		JButton botaoEntregadores = new JButton("Adicionar Entregador");
		ent.add(botaoEntregadores);
		botaoEntregadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEntregadoresActionPerformed(evt);
            }

			private void jButtonAddEntregadoresActionPerformed(ActionEvent evt) {
				//manipulando o arquivo referente aos entregadores
				String filename = "data/entregadores.txt";
				try {
					Formatter output = new Formatter(filename);
					//nome, cpf, email, telefone e status
					output.format("%s %s %s %s %s %s %d\n", nomeEnt, cpfEnt, emailEnt, telEnt, statusEnt);
					output.flush();
					output.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		javax.swing.GroupLayout entLayout = new javax.swing.GroupLayout(ent);
		ent.setLayout(entLayout);
		  entLayout.setHorizontalGroup(
		      entLayout.createParallelGroup
		      (javax.swing.GroupLayout.Alignment.LEADING)
		      .addGroup(entLayout.createSequentialGroup()
		          .addContainerGap()
		          .addGroup(entLayout.createParallelGroup
		          (javax.swing.GroupLayout.Alignment.LEADING)
		              .addComponent(nomeEnt, javax.swing
		              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
		              .GroupLayout.PREFERRED_SIZE)
		              .addComponent(nomeEnt))
		          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  entLayout.setHorizontalGroup(
				  entLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(entLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(entLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(cpfEnt, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(cpfEnt))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  entLayout.setHorizontalGroup(
			      entLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(entLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(entLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(emailEnt, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(emailEnt))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  entLayout.setHorizontalGroup(
			      entLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(entLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(entLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(telEnt, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(telEnt))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  entLayout.setHorizontalGroup(
			      entLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(entLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(entLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(statusEnt, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(statusEnt))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		
//------------------------------------------PEDIDOS------------------------------------
		
		JPanel ped = new javax.swing.JPanel();
		frameRestaurante.add("Pedidos", ped);
		
		JLabel labelNomeCliente = new JLabel();
		labelNomeCliente.setText("Nome do Cliente: ");
		JTextField nomePed = new JTextField();
		
		JLabel labelvalorPedido = new JLabel();
		labelvalorPedido.setText("Valor do Pedido: ");
		JTextField valorPed = new JTextField();
		
		JLabel labelMetodoPagamento = new JLabel();
		labelMetodoPagamento.setText("Método de Pagamento: ");
		JTextField metodoPagPed = new JTextField();
		
		JLabel labelStatusPedido= new JLabel();
		labelStatusPedido.setText("Status do Pedido: ");
		JTextField statusPed = new JTextField();
		
		JButton botaoPedido = new JButton("Adicionar Pedido");
		ped.add(botaoPedido);
		botaoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPedidoActionPerformed(evt);
            }

			private void jButtonAddPedidoActionPerformed(ActionEvent evt) {
					//manipulando o arquivo referente aos pedidos
					String filename = "data/pedidos.txt";
					try {
						Formatter output = new Formatter(filename);
						//nome, cpf, email, telefone e status
						output.format("%s %.2f %s\n", nomePed, valorPed, metodoPagPed, statusPed);
						output.flush();
						output.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
				
        });
	
		javax.swing.GroupLayout pedLayout = new javax.swing.GroupLayout(ped);
		ped.setLayout(pedLayout);
		  pedLayout.setHorizontalGroup(
		      pedLayout.createParallelGroup
		      (javax.swing.GroupLayout.Alignment.LEADING)
		      .addGroup(pedLayout.createSequentialGroup()
		          .addContainerGap()
		          .addGroup(pedLayout.createParallelGroup
		          (javax.swing.GroupLayout.Alignment.LEADING)
		              .addComponent(nomePed, javax.swing
		              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
		              .GroupLayout.PREFERRED_SIZE)
		              .addComponent(nomePed))
		          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  pedLayout.setHorizontalGroup(
				  pedLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(pedLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(pedLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(valorPed, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(valorPed))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  pedLayout.setHorizontalGroup(
			      pedLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(pedLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(pedLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(metodoPagPed, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(metodoPagPed))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		  pedLayout.setHorizontalGroup(
			      pedLayout.createParallelGroup
			      (javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(pedLayout.createSequentialGroup()
			          .addContainerGap()
			          .addGroup(pedLayout.createParallelGroup
			          (javax.swing.GroupLayout.Alignment.LEADING)
			              .addComponent(statusPed, javax.swing
			              .GroupLayout.PREFERRED_SIZE, 228, javax.swing
			              .GroupLayout.PREFERRED_SIZE)
			              .addComponent(statusPed))
			          .addContainerGap(137, Short.MAX_VALUE))
		  );
		
		
		frameRestaurante.pack();
		frameRestaurante.show();
	}
	
}
