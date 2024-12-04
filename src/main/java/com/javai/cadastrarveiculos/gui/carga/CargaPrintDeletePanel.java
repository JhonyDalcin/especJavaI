/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.gui.carga;

import com.javai.cadastrarveiculos.model.Carga;
import com.javai.cadastrarveiculos.service.BDVeiculos;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhony
 */
public class CargaPrintDeletePanel extends JFrame {
    
    private static CargaPrintDeletePanel cargaPrintDeletePanelUniq;
    private final BDVeiculos bdVeiculos = BDVeiculos.getInstance();
    private final int width = 500, heigth = 550;
    
    //table head
    private final String[] columns = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas",
                                      "Veloc Max", "Qtd. Pist", "Potencia", "Tara", "Carga Max"};
    //table body
    private final DefaultTableModel model = new DefaultTableModel(columns, 0);
    private final JTable dataTable = new JTable(model);
    private final JScrollPane listScrollBar = new JScrollPane(dataTable);
    
    private CargaPrintDeletePanel(){
        loadWindow();
        setLocationRelativeTo(null);
    }
    
    public static CargaPrintDeletePanel getInstance(){
        if (cargaPrintDeletePanelUniq == null){
            cargaPrintDeletePanelUniq = new CargaPrintDeletePanel();
        }
        return cargaPrintDeletePanelUniq;
    }
    
    private void loadWindow(){
        
        setTitle("Imprimir / Excluir todos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new FlowLayout());
        
        JButton btnPrintAll = new JButton("Imprimir Todos");
        JButton btnDeleteAll = new JButton("Deletar Todos");
        JButton btnExit = new JButton("Sair");
        
        btnPrintAll.addActionListener((ActionEvent evt) -> {
            btnPrintAllActionPerformed();
        });
        
        btnDeleteAll.addActionListener((ActionEvent evt) -> {
            btnDeleteAllActionPerformed();
        });
        
        btnExit.addActionListener((ActionEvent evt) -> {
            dispose();
        });
        
        add(listScrollBar);
        add(btnPrintAll);
        add(btnDeleteAll);
        add(btnExit);
        
    }
    
    private void btnPrintAllActionPerformed(){
        printAll();
    }
    
    private void btnDeleteAllActionPerformed(){
        if (bdVeiculos.deleteAllCarga()){
            cleanTable();
            JOptionPane.showMessageDialog(null,"Veiculos de Carga deletados com suscesso!" , "Carga",  JOptionPane.INFORMATION_MESSAGE);
            
        }else {
            JOptionPane.showMessageDialog(null,"Não há veiculos de carga cadastrados." , "Carga",  JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void printAll(){
       
        if (bdVeiculos.getListPasseio().isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há veiculos de carga cadastrados." , "Carga",  JOptionPane.INFORMATION_MESSAGE);
        }else {
            cleanTable();
            for(Carga c: bdVeiculos.getListCarga()){
                String[] data = {c.getPlaca(), c.getMarca(), c.getModelo(), c.getCor(),
                                 Integer.toString(c.getQtdRodas()), Float.toString(c.getVelocMax()),
                                 Integer.toString(c.getMotor().getQtdPist()), Integer.toString(c.getMotor().getPotencia()), 
                                 Integer.toString(c.getTara()), Integer.toString(c.getCargaMax())};
                model.addRow(data);
            }
        }   
    }
    
    private void cleanTable(){
        model.setRowCount(0);
    }
    
}
