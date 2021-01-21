package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import helpers.TableMouseListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Cardapio extends JPanel implements ActionListener {
    private JTable table;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
    private javax.swing.JButton jButtonSalvar;

    public Cardapio() {

        // sample table data
        String[] columnNames = new String[] {"Nome", "Descrição", "Preço (R$)", "URL da imagem"};
        List<String[]> rowData = new ArrayList<String[]>();


        try {
            File myObj = new File("src/data/cardapio.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] arrData = data.split(",");

              String[] aux = {arrData[0], arrData[1], arrData[2], arrData[3]};
              rowData.add(aux);

              i++;
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[][] simpleArray = new String[ rowData.size() ][];
        rowData.toArray( simpleArray );
        // constructs the table with sample data
        tableModel = new DefaultTableModel(simpleArray, columnNames);
        table = new JTable(tableModel);
         
        // constructs the popup menu
        popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Adicionar nova linha");
        menuItemRemove = new JMenuItem("Remover linha");
        menuItemRemoveAll = new JMenuItem("Remover todas as linhas");
         
        menuItemAdd.addActionListener(this);
        menuItemRemove.addActionListener(this);
        menuItemRemoveAll.addActionListener(this);
         
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);
         
        // sets the popup menu for the table
        table.setComponentPopupMenu(popupMenu);
         
        table.addMouseListener(new TableMouseListener(table));
         
        // adds the table to the frame
        add(new JScrollPane(table));
        // button salvar
        jButtonSalvar = new javax.swing.JButton();
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        add(jButtonSalvar);
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) {
            addNewRow();
        } else if (menu == menuItemRemove) {
            removeCurrentRow();
        } else if (menu == menuItemRemoveAll) {
            removeAllRows();
        }
    }
     
    private void addNewRow() {
        tableModel.addRow(new String[0]);
    }
     
    private void removeCurrentRow() {
        int selectedRow = table.getSelectedRow();
        tableModel.removeRow(selectedRow);
    }
     
    private void removeAllRows() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {

    }
}