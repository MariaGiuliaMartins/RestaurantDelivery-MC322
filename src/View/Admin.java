package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.*;  
    
public class Admin extends javax.swing.JPanel{

    public Admin(){
        
        JLabel esp_extra1 = new JLabel("                                            ");

        //admins
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JTextField campona1 = new JTextField(30);
        JLabel na1 = new JLabel("Nome do Administrador:");
        na1.setVerticalAlignment(JLabel.TOP);
        na1.setLabelFor(campona1);
        this.add(na1);
        this.add(campona1);
        
        JTextField campocpfa1 = new JTextField(30);
        JLabel cpfa1 = new JLabel("CPF do Administrador: ");
        cpfa1.setVerticalAlignment(JLabel.TOP);
        cpfa1.setLabelFor(campocpfa1);
        this.add(cpfa1);
        this.add(campocpfa1);
        
        JTextField campoea1 = new JTextField(30);
        JLabel ea1 = new JLabel("Email do Administrador: ");
        ea1.setLabelFor(campoea1);
        this.add(ea1);
        this.add(campoea1);
        
        JTextField campota1 = new JTextField(30);
        JLabel ta1 = new JLabel("Telefone do Administrador: ");
        ta1.setLabelFor(campota1);
        this.add(ta1);
        this.add(campota1);
        
        Integer[] status = {0, 1};
        @SuppressWarnings({ "unchecked", "rawtypes" })
        JComboBox op_status = new JComboBox(status);
        JLabel sa1 = new JLabel("Status do Administrador: ");
        this.add(sa1);
        this.add(op_status); 
        
        JButton botaoAdmin = new JButton ("<html><body>Adicionar<br> Administrador</body></html>");
        this.add(botaoAdmin);
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
                    output.format("%s %s %s %s %s\n", campona1.getText(), campocpfa1.getText(), campoea1.getText(), campota1.getText(), op_status.getSelectedItem());
                    output.flush();
                    output.close();
                }catch(IOException ex) {
                    ex.printStackTrace();
                }				
            }
        });
    }
}  