package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.*;  
    
    public class Restaurante {  
    
    	JFrame f;  
    
    	public Restaurante(){
    		//frame principal
    		f = new JFrame("Restaurante");  
    		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    		
    		JLabel esp_extra1 = new JLabel("                                            ");
	        
	        //admins
	        JPanel p1 = new JPanel();
	        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        JTextField campona1 = new JTextField(30);
	        JLabel na1 = new JLabel("Nome do Administrador:");
	        na1.setVerticalAlignment(JLabel.TOP);
	        na1.setLabelFor(campona1);
	        p1.add(na1);
	        p1.add(campona1);
	        
	        JTextField campocpfa1 = new JTextField(30);
	        JLabel cpfa1 = new JLabel("CPF do Administrador: ");
	        cpfa1.setVerticalAlignment(JLabel.TOP);
	        cpfa1.setLabelFor(campocpfa1);
	        p1.add(cpfa1);
	        p1.add(campocpfa1);
	        
	        JTextField campoea1 = new JTextField(30);
	        JLabel ea1 = new JLabel("Email do Administrador: ");
	        ea1.setLabelFor(campoea1);
	        p1.add(ea1);
	        p1.add(campoea1);
	        
	        JTextField campota1 = new JTextField(30);
	        JLabel ta1 = new JLabel("Telefone do Administrador: ");
	        ta1.setLabelFor(campota1);
	        p1.add(ta1);
	        p1.add(campota1);
	        
	        Integer[] status = {0, 1};
	        @SuppressWarnings({ "unchecked", "rawtypes" })
			JComboBox op_status = new JComboBox(status);
	        JLabel sa1 = new JLabel("Status do Administrador: ");
	        p1.add(sa1);
	        p1.add(op_status); 
	        
	        JButton botaoAdmin = new JButton ("<html><body>Adicionar<br> Administrador</body></html>");
	        p1.add(botaoAdmin);
	        botaoAdmin.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButtonAddAdminActionPerformed(evt);
	            }

				private void jButtonAddAdminActionPerformed(ActionEvent evt) {
					//manipulando o arquivo referente aos admins
					String filename = "src/data/administradores.txt";
					try {
						Formatter output = new Formatter(filename);
						//nome, cpf, email, telefone e status
						output.format("%s %s %s %s %s %s %d\n", campona1, campocpfa1, campoea1, campota1, op_status.getSelectedItem());
						output.flush();
						output.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}				
				}
	        });
	        
	        				  
	        				  
	        //funcionarios
	        JPanel p2 = new JPanel();
	        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        JTextField camponf1 = new JTextField(30);
	        JLabel nf1 = new JLabel("Nome do Funcionário:");
	        nf1.setVerticalAlignment(JLabel.TOP);
	        nf1.setLabelFor(camponf1);
	        p2.add(nf1);
	        p2.add(camponf1);
	        
	        JTextField campocpff1 = new JTextField(30);
	        JLabel cpff1 = new JLabel("CPF do Funcionário: ");
	        cpff1.setVerticalAlignment(JLabel.TOP);
	        cpff1.setLabelFor(campocpff1);
	        p2.add(cpff1);
	        p2.add(campocpff1);
	        
	        JTextField campoef1 = new JTextField(30);
	        JLabel ef1 = new JLabel("Email do Funcionário: ");
	        ef1.setLabelFor(campoef1);
	        p2.add(ef1);
	        p2.add(campoef1);
	        
	        JTextField campotf1 = new JTextField(30);
	        JLabel tf1 = new JLabel("Telefone do Funcionário: ");
	        tf1.setLabelFor(campotf1);
	        p2.add(tf1);
	        p2.add(campotf1);
	        
	        Integer[] status1 = {0, 1};
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox op_status1 = new JComboBox(status1);
	        JLabel st1 = new JLabel("Status do Funcionário: ");
	        p2.add(st1);
	        p2.add(op_status1);
	        
	        JButton botaoFunc = new JButton("<html><body>Adicionar<br> Funcionário</body></html>");
	        p2.add(botaoFunc);
			botaoFunc.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButtonAddFuncActionPerformed(evt);
	            }

				private void jButtonAddFuncActionPerformed(ActionEvent evt) {
					//manipulando o arquivo referente aos funcionarios
					String filename = "src/data/funcionarios.txt";
					try {
						Formatter output = new Formatter(filename);
						//nome, cpf, email, telefone e status
						output.format("%s %s %s %s %s %s %d\n", camponf1, campocpff1, campoef1, campotf1, op_status1.getSelectedItem());
						output.flush();
						output.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
	        });
	        
			
	        //entregadores
	        JPanel p3 = new JPanel();
	        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        JTextField campone1 = new JTextField(30);
	        JLabel ne1 = new JLabel("Nome do Entregador:");
	        ne1.setVerticalAlignment(JLabel.TOP);
	        ne1.setLabelFor(campone1);
	        p3.add(ne1);
	        p3.add(campone1);
	        
	        JTextField campocpfe1 = new JTextField(30);
	        JLabel cpfe1 = new JLabel("CPF do Entregador: ");
	        cpfe1.setVerticalAlignment(JLabel.TOP);
	        cpfe1.setLabelFor(campocpfe1);
	        p3.add(cpfe1);
	        p3.add(campocpfe1);
	        
	        JTextField campoee1 = new JTextField(30);
	        JLabel ee1 = new JLabel("Email do Entregador: ");
	        ee1.setLabelFor(campoee1);
	        p3.add(ee1);
	        p3.add(campoee1);
	        
	        JTextField campote1 = new JTextField(30);
	        JLabel te1 = new JLabel("Telefone do Entregador: ");
	        te1.setLabelFor(campote1);
	        p3.add(te1);
	        p3.add(campote1);
	        
	        Integer[] status2 = {0, 1};
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox op_status2 = new JComboBox(status2);
	        JLabel st2 = new JLabel("Status do Entregador: ");
	        p3.add(st2);
	        p3.add(op_status2);
	        
	        JButton botaoEntregadores = new JButton("<html><body>Adicionar<br> Entregador</body></html>");
			p3.add(botaoEntregadores);
			botaoEntregadores.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButtonAddEntregadoresActionPerformed(evt);
	            }

				private void jButtonAddEntregadoresActionPerformed(ActionEvent evt) {
					//manipulando o arquivo referente aos entregadores
					String filename = "src/data/entregadores.txt";
					try {
						Formatter output = new Formatter(filename);
						//nome, cpf, email, telefone e status
						output.format("%s %s %s %s %s %s %d\n", campone1, campocpfe1, campoee1, campote1, op_status2.getSelectedItem());
						output.flush();
						output.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			});
	        
	        //pedidos
	        JPanel p4 = new JPanel();
	        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        JTextField camponp1 = new JTextField(40);
	        JLabel np1 = new JLabel("Nome do Cliente:");
	        np1.setVerticalAlignment(JLabel.TOP);
	        np1.setLabelFor(camponp1);
	        p4.add(np1);
	        p4.add(camponp1);
	        	        
	        String[] metodo_pagamento = {"Cartão de Débito", "Cartão de Crédito", "Dinheiro", "Vale Alimentação", "Vale Refeição"};
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox pagto = new JComboBox(metodo_pagamento);
	        JLabel pag = new JLabel("Método de Pagamento: ");
	        p4.add(pag);
	        p4.add(pagto);
	        p4.add(esp_extra1);
	        
	        String[] status3 = {"Pedido em Processamento", "Pedido Recusado", "Pedido Aprovado", "Pedido em Preparação", "Pedido Enviado", "Pedido Entregue"};
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox op_status3 = new JComboBox(status3);
	        JLabel st3 = new JLabel("Status do Pedido: ");
	        p4.add(st3);
	        p4.add(op_status3);
	        
	        JButton botaoPedido = new JButton("<html><body>Adicionar<br> Pedido</body></html>");
			p4.add(botaoPedido);
			botaoPedido.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButtonAddPedidoActionPerformed(evt);
	            }

				private void jButtonAddPedidoActionPerformed(ActionEvent evt) {
						//manipulando o arquivo referente aos pedidos
						String filename = "src/data/pedidos.txt";
						try {
							Formatter output = new Formatter(filename);
							//nome, cpf, email, telefone e status
							output.format("%s %.2f %s\n", camponp1, pagto.getSelectedItem(), op_status3.getSelectedItem());
							output.flush();
							output.close();
						}catch(IOException ex) {
							ex.printStackTrace();
						}
					}
					
	        });
	        
	        JTabbedPane tp = new JTabbedPane();  
	        tp.setBounds(1, 1, 600, 400);  
	        tp.add("Administradores", p1);
	        tp.add("Funcionários", p2);  
	        tp.add("Entregadores", p3);
	        tp.add("Pedidos", p4);
	        
	        f.add(tp);  
	        f.setSize(600, 400);  
	        f.setLayout(null);  
	        f.setVisible(true);  
    	}  
    }  