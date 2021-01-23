package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.CardapioController;
import Exceptions.InvalidValue;
import Model.Bebida;
import Model.Comida;
import helpers.TableMouseListener;

import java.util.ArrayList;
import java.util.List;

public class Cardapio extends JPanel implements ActionListener {
    private JTable tableComidas;
    private JTable tableBebidas;
    private DefaultTableModel tableModelComidas;
    private DefaultTableModel tableModelBebidas;

    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
    private JPopupMenu popupMenuBebidas;
    private JMenuItem menuItemAddBebidas;
    private JMenuItem menuItemRemoveBebidas;
    private JMenuItem menuItemRemoveAllBebidas;
    private JButton jButtonSalvar;

    private CardapioController cardapioController;
    public Cardapio(CardapioController cardapioController) {

        this.cardapioController = cardapioController;

        String[] columnNames = new String[] {"Nome", "Descrição", "Preço (R$)", "URL da imagem"};

        // comida table
        List<String[]> rowDataComida = new ArrayList<String[]>();

        for (Comida comida : cardapioController.getComidas()){
            String[] aux = {comida.getNome(), comida.getDescricao(), Double.toString(comida.getPreco()), comida.getImagem()};
            rowDataComida.add(aux);
        }

        String[][] arrayComidas = new String[ rowDataComida.size() ][];
        rowDataComida.toArray( arrayComidas );
        // constructs the table with sample data
        tableModelComidas = new DefaultTableModel(arrayComidas, columnNames);
        tableComidas = new JTable(tableModelComidas);
         
        // constructs the popup menu
        popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Adicionar nova linha");
        menuItemRemove = new JMenuItem("Remover linha");
        menuItemRemoveAll = new JMenuItem("Remover todas as linhas");
         
        menuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRowComida(evt);
            }
        });
        menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCurrentRowComida(evt);
            }
        });
        menuItemRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllRowsComida(evt);
            }
        });
         
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);
         
        // sets the popup menu for the table
        tableComidas.setComponentPopupMenu(popupMenu);
        tableComidas.addMouseListener(new TableMouseListener(tableComidas));

        // bebida table

        List<String[]> rowDataBebida = new ArrayList<String[]>();

        for (Bebida bebida : cardapioController.getBebidas()){
            String[] aux = {bebida.getNome(), bebida.getDescricao(), Double.toString(bebida.getPreco()), bebida.getImagem()};
            rowDataBebida.add(aux);
        }

        String[][] arrayBebidas = new String[ rowDataBebida.size() ][];
        rowDataBebida.toArray( arrayBebidas );
        // constructs the table with sample data
        tableModelBebidas = new DefaultTableModel(arrayBebidas, columnNames);
        tableBebidas = new JTable(tableModelBebidas);

        // constructs the popup menu
        popupMenuBebidas = new JPopupMenu();
        menuItemAddBebidas = new JMenuItem("Adicionar nova linha");
        menuItemRemoveBebidas = new JMenuItem("Remover linha");
        menuItemRemoveAllBebidas = new JMenuItem("Remover todas as linhas");

        menuItemAddBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRowBebida(evt);
            }
        });
        menuItemRemoveBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCurrentRowBebida(evt);
            }
        });
        menuItemRemoveAllBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllRowsBebida(evt);
            }
        });

        popupMenuBebidas.add(menuItemAddBebidas);
        popupMenuBebidas.add(menuItemRemoveBebidas);
        popupMenuBebidas.add(menuItemRemoveAllBebidas);

        // sets the popup menu for the table
        tableBebidas.setComponentPopupMenu(popupMenuBebidas);
        tableBebidas.addMouseListener(new TableMouseListener(tableBebidas));
         
        // adds the table to the frame
        add(new JScrollPane(tableBebidas));
        add(new JScrollPane(tableComidas));


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
    public void actionPerformed(ActionEvent e) {

    }

    private void addNewRowComida(java.awt.event.ActionEvent evt) {
        tableModelComidas.addRow(new String[0]);
    }
     
    private void removeCurrentRowComida(java.awt.event.ActionEvent evt) {
        int selectedRow = tableComidas.getSelectedRow();
        tableModelComidas.removeRow(selectedRow);
    }
     
    private void removeAllRowsComida(java.awt.event.ActionEvent evt) {
        int rowCount = tableModelComidas.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModelComidas.removeRow(0);
        }
    }

    private void addNewRowBebida(java.awt.event.ActionEvent evt) {
        tableModelBebidas.addRow(new String[0]);
    }

    private void removeCurrentRowBebida(java.awt.event.ActionEvent evt) {
        int selectedRow = tableBebidas.getSelectedRow();
        tableModelBebidas.removeRow(selectedRow);
    }

    private void removeAllRowsBebida(java.awt.event.ActionEvent evt) {
        int rowCount = tableModelBebidas.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModelBebidas.removeRow(0);
        }
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        cardapioController.reset();
        for (int count = 0; count < tableModelComidas.getRowCount(); count++){
            Comida comida;
            Object nome = tableModelComidas.getValueAt(count,0);
            Object desc = tableModelComidas.getValueAt(count,1);
            Object preco = tableModelComidas.getValueAt(count,2);
            Object img = tableModelComidas.getValueAt(count,3);

            if (img == null || nome == null || desc == null || preco == null){
                JOptionPane.showMessageDialog(null, "Verifique se os campos de comidas estao todos preenchidos");
                return;
            } else{
                try {
                    if ( Double.valueOf(preco.toString()) <=  0)
                        throw new InvalidValue();
                    comida = new Comida(nome.toString(), desc.toString(), Double.parseDouble(preco.toString()), img.toString());
                    cardapioController.addItem(comida);
                } catch (InvalidValue e){
                    e.printStackTrace();
                }
            }
        }
        for (int count = 0; count < tableModelBebidas.getRowCount(); count++){

            Bebida bebida;
            Object nome = tableModelBebidas.getValueAt(count,0);
            Object desc = tableModelBebidas.getValueAt(count,1);
            Object preco = tableModelBebidas.getValueAt(count,2);
            Object img = tableModelBebidas.getValueAt(count,3);

            if (img == null || nome == null || desc == null || preco == null){
                JOptionPane.showMessageDialog(null, "Verifique se os campos de bebidas estao todos preenchidos");
                return;
            } else{
                bebida = new Bebida(nome.toString(), desc.toString(), Double.parseDouble(preco.toString()), img.toString());
                cardapioController.addItem(bebida);
            }
        }
        this.cardapioController.save();
    }
}