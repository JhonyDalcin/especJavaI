package com.javai.cadastrarveiculos.gui.passeio;

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
public class MainPasseioPanel extends JFrame{

    private static MainPasseioPanel instPasseioPanelUniq;
    private final int width = 300, heigth = 300;

    private MainPasseioPanel() {
        loadWindow();
        setLocationRelativeTo(null);
    }

    public static MainPasseioPanel getInstance() {
        if (instPasseioPanelUniq == null) {
            instPasseioPanelUniq = new MainPasseioPanel();
        }
        return instPasseioPanelUniq;
    }

    private void loadWindow() {

        //Panel layout design
        setTitle("Veiculos de Passeio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        //button
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

        // buttons actions definition
        btnRegister.addActionListener((ActionEvent evt) -> {
            btnRegisterActionPerformed();
        });

        btnFindDeleteByPlate.addActionListener((ActionEvent evt) -> {
            btnFindDeleteByPlateActionPerformed();
        });

        btnPrintDelete.addActionListener((ActionEvent evt) -> {
            btnPrintDeleteActionPerformed();
        });

        btnExit.addActionListener((ActionEvent evt) -> {
            btnExitActionPerformed();
        });

    }

    private void btnRegisterActionPerformed() {
        openPasseioRegisterPanel();
    }

    private void btnFindDeleteByPlateActionPerformed() {
        openPasseioFindDeleteByPlatePanel();
    }

    private void btnPrintDeleteActionPerformed() {
        openPasseioPrintDelete();
    }

    private void btnExitActionPerformed() {
        dispose();
    }

    private void openPasseioRegisterPanel() {
        PasseioRegisterPanel.getInstance().setVisible(true);
    }

    private void openPasseioFindDeleteByPlatePanel() {
        PasseioFindDeleteByPlatePanel.getInstance().setVisible(true);
    }

    private void openPasseioPrintDelete() {
        PasseioPrintDeletePanel.getInstance().setVisible(true);
    }

}