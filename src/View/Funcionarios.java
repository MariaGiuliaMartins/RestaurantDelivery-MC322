package View;

import Models.Funcionario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.*;

public class Funcionarios extends javax.swing.JPanel {

    public Funcionarios(){
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField camponf1 = new JTextField(30);
        JLabel nf1 = new JLabel("Nome do Funcionário:");
        nf1.setVerticalAlignment(JLabel.TOP);
        nf1.setLabelFor(camponf1);
        this.add(nf1);
        this.add(camponf1);

        JTextField campocpff1 = new JTextField(30);
        JLabel cpff1 = new JLabel("CPF do Funcionário: ");
        cpff1.setVerticalAlignment(JLabel.TOP);
        cpff1.setLabelFor(campocpff1);
        this.add(cpff1);
        this.add(campocpff1);

        JTextField campoef1 = new JTextField(30);
        JLabel ef1 = new JLabel("Email do Funcionário: ");
        ef1.setLabelFor(campoef1);
        this.add(ef1);
        this.add(campoef1);

        JTextField campotf1 = new JTextField(30);
        JLabel tf1 = new JLabel("Telefone do Funcionário: ");
        tf1.setLabelFor(campotf1);
        this.add(tf1);
        this.add(campotf1);

        Integer[] status1 = {0, 1};
        @SuppressWarnings({ "rawtypes", "unchecked" })
        JComboBox op_status1 = new JComboBox(status1);
        JLabel st1 = new JLabel("Status do Funcionário: ");
        this.add(st1);
        this.add(op_status1);

        JButton botaoFunc = new JButton("<html><body>Adicionar<br> Funcionário</body></html>");
        this.add(botaoFunc);
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
                    output.format("%s %s %s %s\n", camponf1.getText(), campocpff1.getText(), campoef1.getText(), campotf1.getText(), op_status1.getSelectedItem());
                    output.flush();
                    output.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
