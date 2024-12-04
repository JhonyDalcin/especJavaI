/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.gui.passeio;

import com.javai.cadastrarveiculos.model.Passeio;
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
public class PasseioPrintDeletePanel extends JFrame {
    
    private static PasseioPrintDeletePanel passeioPrintDeletePanelUniq;
    private BDVeiculos bdVeiculos = BDVeiculos.getInstance();
    private final int width = 500, heigth = 550;
    
    //table head
    private final String[] columns = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas",
                                      "Veloc Max", "Qtd. Pist", "Potencia", "Qtd. Passageiro",};
    //table body
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    private JTable dataTable = new JTable(model);
    private JScrollPane listScrollBar = new JScrollPane(dataTable);
    
    private PasseioPrintDeletePanel(){
        loadWindow();
        setLocationRelativeTo(null);
    }
    
    public static PasseioPrintDeletePanel getInstance(){
        if (passeioPrintDeletePanelUniq == null){
            passeioPrintDeletePanelUniq = new PasseioPrintDeletePanel();
        }
        return passeioPrintDeletePanelUniq;
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

        if (bdVeiculos.deleteAllPasseio()){
            cleanTable();
            JOptionPane.showMessageDialog(null,"Veiculos de Passeio deletados com suscesso!" , "Passeio",  JOptionPane.INFORMATION_MESSAGE);
            
        }else {
            JOptionPane.showMessageDialog(null,"Não há veiculos de passeio cadastrados." , "Passeio",  JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void printAll(){
       
        if (bdVeiculos.getListPasseio().isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há veiculos de passeio cadastrados." , "Passeio",  JOptionPane.INFORMATION_MESSAGE);
        }else {
            cleanTable();
            for(Passeio p: bdVeiculos.getListPasseio()){
                String[] data = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getCor(),
                                 Integer.toString(p.getQtdRodas()), Float.toString(p.getVelocMax()),
                                 Integer.toString(p.getMotor().getQtdPist()), Integer.toString(p.getMotor().getPotencia()), 
                                 Integer.toString(p.getQtdPassageiros())};
                model.addRow(data);
            }
        }   
    }
    
    private void cleanTable(){
        model.setRowCount(0);
    }
    
}
