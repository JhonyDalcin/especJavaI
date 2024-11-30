package com.javai.cadastrarveiculos.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jhony
 */
public class MainCargaPanel extends JFrame {
    
    private static MainCargaPanel instCargaPanelUniq;
        
    private final int width = 300, heigth = 300;
    
    private MainCargaPanel(){
        loadWindow();
        setLocationRelativeTo(null);
    }
    
    public static MainCargaPanel getInstance(){
        if (instCargaPanelUniq == null){
            instCargaPanelUniq = new MainCargaPanel();
        }
        return instCargaPanelUniq;
    }
    
    private void loadWindow(){
        
        //Panel layout design
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        //Buttons
        JButton btnRegister = new JButton("Cadastrar");
        JButton btnFindDeleteByPlate = new JButton("Consultar / Excluir pela placa");
        JButton btnPrintDelete = new JButton("Imprimir / Excluir todos");
        JButton btnExit = new JButton("Sair");
        btnRegister.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnFindDeleteByPlate.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnPrintDelete.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(JButton.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnRegister);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnFindDeleteByPlate);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnPrintDelete);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnExit);
        
        //Buttons actions definition
        btnRegister.addActionListener((ActionEvent evt) -> {
            btnRegisterActionListner(evt);
        });
        
        btnFindDeleteByPlate.addActionListener((ActionEvent evt) -> {
            btnFindDeleteByPlate(evt);
        });
        
        btnPrintDelete.addActionListener((ActionEvent evt) -> {
            btnPrintDeleteActionListner(evt);
        });
        
        btnExit.addActionListener((ActionEvent evt) -> {
            btnExitActionListner(evt);
        });
                
    }
    
    private void btnRegisterActionListner(ActionEvent evt) {
        openCargaRegisterPanel();
    }
    
    private void btnFindDeleteByPlate(ActionEvent evt) {
        openCargaFindDeleteByPlatePanel();
    }
    
    private void btnPrintDeleteActionListner(ActionEvent evt) {
        openCargaPrintDelete();
    }
    
    private void btnExitActionListner(ActionEvent evt) {
        exitConfirmationMessage();
    }
    
    private void openCargaRegisterPanel(){
        JOptionPane.showMessageDialog(
                null,
                "Register Passeio here!",
                "Passeio",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void openCargaFindDeleteByPlatePanel(){
        JOptionPane.showMessageDialog(
                null,
                "Find Delete Passeio by plate here!",
                "Passeio",
                JOptionPane.INFORMATION_MESSAGE
        );
    } 
    
    private void openCargaPrintDelete(){
        JOptionPane.showMessageDialog(
                null,
                "Print and Delete here!",
                "Passeio",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void exitConfirmationMessage(){
        
            int confirmation = JOptionPane.showConfirmDialog(
                null,
                "You are exiting the current panel, are you sure?!",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmation == 0){
                dispose();
            }
    } 
}
