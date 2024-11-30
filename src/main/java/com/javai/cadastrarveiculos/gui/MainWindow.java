package com.javai.cadastrarveiculos.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jhony
 */
public class MainWindow extends JFrame {
    
    private static MainWindow mainWindowUniq;
    
    private MainWindow(){
        loadWindow();
        setLocationRelativeTo(null);
    }
    
    public static MainWindow getInstance(){
        if (mainWindowUniq == null){
            mainWindowUniq = new MainWindow();
        }
        return mainWindowUniq;
    }
    
    private final int width = 300, heigth = 150;
        
    private void loadWindow(){
        
        //Panel layout design
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, heigth);
        setTitle("Gestao de Veiculos");
        
        JButton btnPasseio = new JButton("Passeio");
        JButton btnCarga = new JButton("Carga");
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        btnPasseio.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnCarga.setAlignmentX(JButton.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnPasseio);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnCarga);
        
        // buttons actions definition
        btnPasseio.addActionListener((ActionEvent evt) -> {
            btnPasseioActionListner(evt);
        });
        
        btnCarga.addActionListener((ActionEvent evt) -> {
            btnCargaActionListner(evt);
        });
                
    }
    
    private void btnPasseioActionListner(ActionEvent evt) {
        openPasseioPanel();
    }
    
    private void btnCargaActionListner(ActionEvent evt) {
        openCargaPanel();
    }
    
    private void openPasseioPanel(){
        MainPasseioPanel.getInstance().setVisible(true);
    }
    
    private void openCargaPanel(){
        MainCargaPanel.getInstance().setVisible(true);
    }

}
