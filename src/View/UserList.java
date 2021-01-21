package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import helpers.TableMouseListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class UserList extends JFrame implements ActionListener {
    private JTable table;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
     
    public UserList() {
        super("UserList");
         
        String[] columnNames = new String[] {"Nome", "CPF", "E-mail", "Telefone", "Sexo", "Rua", "Número", "Bairro", "Cidade", "Estado"};
        String[][] rowData = new String[1000][1000];

        try {
            File myObj = new File("src/data/usuarios.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] arrData = data.split(",");
              
              String[] aux = {arrData[0], arrData[1], arrData[2], arrData[3], arrData[4], arrData[5], arrData[6], arrData[7], arrData[8], arrData[9]};
              rowData[i] = aux;
              i++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         
        // constructs the table with sample data
        tableModel = new DefaultTableModel(rowData, columnNames);
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
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 450);
        setLocationRelativeTo(null);
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
}