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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author jhony
 */
public class PasseioFindDeleteByPlatePanel extends JFrame {
    
    private BDVeiculos bdVeiculos = BDVeiculos.getInstance();
    private static PasseioFindDeleteByPlatePanel passeioFindDeleteUniq;
    int width = 500, heigth = 300;
    
    //Entries data box
    JTextField tfQtdPassageiros;
    JTextField tfPlaca;
    JTextField tfMarca;
    JTextField tfModelo;
    JTextField tfCor;
    JTextField tfQtdRodas;
    JTextField tfVelocMax;
    JTextField tfQtdPistoes;
    JTextField tfPotencia;
    
    private PasseioFindDeleteByPlatePanel(){
       loadWindow();
       setLocationRelativeTo(null);
    }
    
    public static PasseioFindDeleteByPlatePanel getInstance(){
        if (passeioFindDeleteUniq == null){
            passeioFindDeleteUniq = new PasseioFindDeleteByPlatePanel();
        }
        return passeioFindDeleteUniq;
    }
    
    private void loadWindow(){
        
        setTitle("Consultar/Excluir pela placa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new FlowLayout());
        
        //Entries data box
        JLabel lQtdPassageiros = new JLabel("Qtd. Passageiros: ");
        tfQtdPassageiros = new JTextField(5);
        JLabel lPlaca = new JLabel("Informe a Placa: ");
        tfPlaca = new JTextField(5);
        JLabel lMarca = new JLabel("Marca: ");
        tfMarca = new JTextField(10);
        JLabel lModelo = new JLabel("Modelo: ");
        tfModelo = new JTextField(10);
        JLabel lCor = new JLabel("Cor: ");
        tfCor = new JTextField(5);
        JLabel lQtdRodas = new JLabel("Qtd. Rodas: ");
        tfQtdRodas = new JTextField(5);
        JLabel lVelocMax = new JLabel("Velocidade Max.: ");
        tfVelocMax = new JTextField(5);
        JLabel lQtdPistoes = new JLabel("Qtd. Pistoes: ");
        tfQtdPistoes = new JTextField(5);
        JLabel lPotencia = new JLabel("Potencia: ");
        tfPotencia = new JTextField(5);
        
        JButton btnFind = new JButton("Consultar");
        JButton btnDelete = new JButton("Excluir");
        JButton btnExit = new JButton("Sair");
        
        btnFind.addActionListener((ActionEvent evt) -> {
            btnFindActionPerformed();
        });
        btnDelete.addActionListener((ActionEvent evt) -> {
            btnDeleteActionPerformed();
        });
        btnExit.addActionListener((ActionEvent evt) -> {
            dispose();
        });
        
        //adding components
        add(lPlaca);
        add(tfPlaca);
        add(lQtdPassageiros);
        add(tfQtdPassageiros);
        add(lMarca);
        add(tfMarca);
        add(lModelo);
        add(tfModelo);
        add(lCor);
        add(tfCor);
        add(lQtdRodas);
        add(tfQtdRodas);
        add(lVelocMax);
        add(tfVelocMax);
        add(lQtdPistoes);
        add(tfQtdPistoes);
        add(lPotencia);
        add(tfPotencia);        
        add(btnFind);
        add(btnDelete);
        add(btnExit);
        
    }
    
    private void btnFindActionPerformed(){
        Passeio p = bdVeiculos.printPasseioByPlate(tfPlaca.getText());
        if (p != null){
            tfQtdPassageiros.setText(Integer.toString(p.getQtdPassageiros()));
            tfQtdRodas.setText(Integer.toString(p.getQtdRodas()));
            tfQtdPistoes.setText(Integer.toString(p.getMotor().getQtdPist()));
            tfPotencia.setText(Integer.toString(p.getMotor().getPotencia()));
            tfVelocMax.setText(Float.toString(p.getVelocMax()));
            tfPlaca.setText(p.getPlaca());
            tfMarca.setText(p.getMarca());
            tfModelo.setText(p.getModelo());
            tfCor.setText(p.getCor());
        }else{
            vehiclePlateNotFound();
            clean();
        }
    }
    private void btnDeleteActionPerformed(){
        if (bdVeiculos.removeVeiculoPasseio(tfPlaca.getText())){
            JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            clean();
        }else {
            clean();
            vehiclePlateNotFound();
        }
    }
    
    private void clean(){
        tfQtdPassageiros.setText("");
        tfQtdRodas.setText("");
        tfQtdPistoes.setText("");
        tfPotencia.setText("");
        tfVelocMax.setText("");
        tfMarca.setText("");
        tfModelo.setText("");
        tfCor.setText("");
    }
    
    private void vehiclePlateNotFound(){
        JOptionPane.showMessageDialog(null, "Veiculo de Passeio nao encontrado!",
                                      "Passeio", JOptionPane.INFORMATION_MESSAGE);
    }
     
}
