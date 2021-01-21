package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Formatter;

public class Entregadores extends JPanel {
    public Entregadores(){

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField campone1 = new JTextField(30);
        JLabel ne1 = new JLabel("Nome do Entregador:");
        ne1.setVerticalAlignment(JLabel.TOP);
        ne1.setLabelFor(campone1);
        this.add(ne1);
        this.add(campone1);

        JTextField campocpfe1 = new JTextField(30);
        JLabel cpfe1 = new JLabel("CPF do Entregador: ");
        cpfe1.setVerticalAlignment(JLabel.TOP);
        cpfe1.setLabelFor(campocpfe1);
        this.add(cpfe1);
        this.add(campocpfe1);

        JTextField campoee1 = new JTextField(30);
        JLabel ee1 = new JLabel("Email do Entregador: ");
        ee1.setLabelFor(campoee1);
        this.add(ee1);
        this.add(campoee1);

        JTextField campote1 = new JTextField(30);
        JLabel te1 = new JLabel("Telefone do Entregador: ");
        te1.setLabelFor(campote1);
        this.add(te1);
        this.add(campote1);

        Integer[] status2 = {0, 1};
        @SuppressWarnings({ "rawtypes", "unchecked" })
        JComboBox op_status2 = new JComboBox(status2);
        JLabel st2 = new JLabel("Status do Entregador: ");
        this.add(st2);
        this.add(op_status2);

        JButton botaoEntregadores = new JButton("<html><body>Adicionar<br> Entregador</body></html>");
        this.add(botaoEntregadores);
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
                    output.format("%s %s %s %s %s\n", campone1.getText(), campocpfe1.getText(), campoee1.getText(), campote1.getText(), op_status2.getSelectedItem());
                    output.flush();
                    output.close();
                }catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
