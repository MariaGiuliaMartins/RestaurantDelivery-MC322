package View;

import Controller.ClienteController;
import Controller.EntregadorController;
import Model.Cliente;
import Model.Entregador;
import Model.Sexo;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Clientes extends javax.swing.JPanel {

    private ClienteController clienteController;

    JTextField jTextFieldNome;
    JTextField jTextFielCPF;
    JTextField jTextFieldEmail;
    JTextField jTextFieldTel;
    JComboBox jComboBoxSexo;
    JTable table;
    DefaultTableModel tableModel;


    public Clientes(ClienteController clienteController){

        this.clienteController = clienteController;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        jTextFieldNome = new JTextField(30);
        JLabel nf1 = new JLabel("Nome:");
        nf1.setLabelFor(jTextFieldNome);
        this.add(nf1);
        this.add(jTextFieldNome);

        jTextFielCPF = new JTextField(30);
        JLabel cpff1 = new JLabel("CPF: ");
        cpff1.setLabelFor(jTextFielCPF);
        this.add(cpff1);
        this.add(jTextFielCPF);

        jTextFieldEmail = new JTextField(30);
        JLabel ef1 = new JLabel("Email: ");
        ef1.setLabelFor(jTextFieldEmail);
        this.add(ef1);
        this.add(jTextFieldEmail);

        jTextFieldTel = new JTextField(30);
        JLabel tf1 = new JLabel("Telefone: ");
        tf1.setLabelFor(jTextFieldTel);
        this.add(tf1);
        this.add(jTextFieldTel);

        String[] optionsSexo = {"M", "F"};
        jComboBoxSexo = new JComboBox(optionsSexo);
        JLabel jLabelSexo = new JLabel("Sexo: ");
        this.add(jLabelSexo);
        this.add(jComboBoxSexo);

        JButton botaoFunc = new JButton("<html><body>Adicionar<br> Cliente</body></html>");
        this.add(botaoFunc);
        botaoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        JButton jButtonDelete = new JButton("<html><body>Deletar<br> Cliente</body></html>");
        this.add(jButtonDelete);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        String[] columnNames = new String[] {"Nome", "CPF", "E-mail", "Telefone", "Sexo"};
        List<String[]> rowData = new ArrayList<String[]>();



        for (Cliente cliente : clienteController.getClientes()){
            String[] aux = {cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getSexo().toString()};
            rowData.add(aux);
        }

        String[][] arrayData = new String[ rowData.size() ][];
        rowData.toArray( arrayData );
        // constructs the table with sample data
        tableModel = new DefaultTableModel(arrayData, columnNames);
        table = new JTable(tableModel);

        JScrollPane jScrollPane = new JScrollPane(table);
        this.add(jScrollPane);
    }

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = jTextFieldNome.getText();
        String cpf = jTextFielCPF.getText();
        String email = jTextFieldEmail.getText();
        String tel = jTextFieldTel.getText();
        String sexo = jComboBoxSexo.getSelectedItem().toString();

        if (nome.equals("") || cpf.equals("") || email.equals("") || tel.equals("")) {
            JOptionPane.showMessageDialog(null, "Verifiqiue se os campos estao todos preenchidos");
            return;
        }

        try{
            // Salva no arquivo
            this.clienteController.addCliente(nome, cpf, email, sexo == "F" ? Sexo.FEMININO : Sexo.MASCULINO, tel);
            // Adiciona na lista
            String[] newRow = {nome, cpf, email, tel, sexo};
            tableModel.addRow(newRow);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int index = table.getSelectedRow();
        // check is user selected a row
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da lista");
            return;
        }
        tableModel.removeRow(index);
        clienteController.removeCliente(index);
    }
}
