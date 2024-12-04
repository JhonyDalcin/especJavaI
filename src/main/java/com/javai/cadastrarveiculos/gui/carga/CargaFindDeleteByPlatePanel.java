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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author jhony
 */
public class CargaFindDeleteByPlatePanel extends JFrame {
    
    private BDVeiculos bdVeiculos = BDVeiculos.getInstance();
    private static CargaFindDeleteByPlatePanel cargaFindDeleteUniq;
    int width = 500, heigth = 300;
    
    //Entries data box
    JTextField tfTara;
    JTextField tfCargaMax;
    JTextField tfPlaca;
    JTextField tfMarca;
    JTextField tfModelo;
    JTextField tfCor;
    JTextField tfQtdRodas;
    JTextField tfVelocMax;
    JTextField tfQtdPistoes;
    JTextField tfPotencia;
    
    private CargaFindDeleteByPlatePanel(){
       loadWindow();
       setLocationRelativeTo(null);
    }
    
    public static CargaFindDeleteByPlatePanel getInstance(){
        if (cargaFindDeleteUniq == null){
            cargaFindDeleteUniq = new CargaFindDeleteByPlatePanel();
        }
        return cargaFindDeleteUniq;
    }
    
    private void loadWindow(){
        
        setTitle("Consultar/Excluir pela placa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new FlowLayout());
        
        //Entries data box
        JLabel lTara = new JLabel("Tara: ");
        tfTara = new JTextField(5);
        JLabel lCargaMax = new JLabel("CargaMax: ");
        tfCargaMax = new JTextField(5);
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
        add(lTara);
        add(tfTara);
        add(lCargaMax);
        add(tfCargaMax);
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
        Carga c = bdVeiculos.printCargaByPlate(tfPlaca.getText());
        if (c != null){
            tfTara.setText(Integer.toString(c.getTara()));
            tfCargaMax.setText(Integer.toString(c.getCargaMax()));
            tfQtdRodas.setText(Integer.toString(c.getQtdRodas()));
            tfQtdPistoes.setText(Integer.toString(c.getMotor().getQtdPist()));
            tfPotencia.setText(Integer.toString(c.getMotor().getPotencia()));
            tfVelocMax.setText(Float.toString(c.getVelocMax()));
            tfPlaca.setText(c.getPlaca());
            tfMarca.setText(c.getMarca());
            tfModelo.setText(c.getModelo());
            tfCor.setText(c.getCor());
        }else{
            vehiclePlateNotFound();
            clean();
        }
    }
    private void btnDeleteActionPerformed(){
        if (bdVeiculos.removeVeiculoCarga(tfPlaca.getText())){
            JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            clean();
        }else {
            clean();
            vehiclePlateNotFound();
        }
    }
    
    private void clean(){
        tfTara.setText("");
        tfCargaMax.setText("");
        tfQtdRodas.setText("");
        tfQtdPistoes.setText("");
        tfPotencia.setText("");
        tfVelocMax.setText("");
        tfMarca.setText("");
        tfModelo.setText("");
        tfCor.setText("");
    }
    
    private void vehiclePlateNotFound(){
        JOptionPane.showMessageDialog(null, "Veiculo de Carga nao encontrado!",
                                      "Passeio", JOptionPane.INFORMATION_MESSAGE);
    }
     
}
