/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.gui.carga;


import com.javai.cadastrarveiculos.model.Carga;
import com.javai.cadastrarveiculos.model.Passeio;
import com.javai.cadastrarveiculos.service.BDVeiculos;
import com.javai.cadastrarveiculos.util.exception.EmptyTxtFieldException;
import com.javai.cadastrarveiculos.util.exception.VeicExistException;
import com.javai.cadastrarveiculos.util.exception.VelocException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jhony
 */
public class CargaRegisterPanel extends JFrame {
    
    private static final BDVeiculos bdVeiculos = BDVeiculos.getInstance();
    private static CargaRegisterPanel cargaRegisterPanelUniq;
    private final int width = 500, heigth = 300;
    
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
   
    private CargaRegisterPanel(){
       loadWindow();
        setLocationRelativeTo(null);
    }
    
    public static CargaRegisterPanel getInstance(){
        if (cargaRegisterPanelUniq == null){
            cargaRegisterPanelUniq = new CargaRegisterPanel();
        }
        return cargaRegisterPanelUniq;
    }
    
    private void loadWindow(){
        
        setTitle("Cadastro de Carga");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width, heigth);
        setLayout(new FlowLayout());
        
        //Entries data box
        JLabel lTara = new JLabel("Tara: ");
        tfTara = new JTextField(5);
        JLabel lCargaMax = new JLabel("Carga Max.: ");
        tfCargaMax = new JTextField(5);
        JLabel lPlaca = new JLabel("Placa: ");
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

        //Buttons
        JButton btnRegistration = new JButton("Cadastrar");
        JButton btnClean = new JButton("Limpar");
        JButton btnNewRegistration = new JButton("Novo");
        JButton btnExit = new JButton("Sair");
                
        btnRegistration.addActionListener((ActionEvent evt) -> {
            btnRegistrationActionPerformed();
        });

        btnClean.addActionListener((ActionEvent evt) -> {
            btnCleannActionPerformed();
        });
        btnNewRegistration.addActionListener((ActionEvent evt) -> {
            btnNewRegistrationActionPerformed();
        });
        btnExit.addActionListener((ActionEvent evt) -> {
            dispose();
        });
        
        //adding components
        add(lTara);
        add(tfTara);
        add(lCargaMax);
        add(tfCargaMax);
        add(lPlaca);
        add(tfPlaca);
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
        add(btnRegistration);
        add(btnClean);
        add(btnNewRegistration);
        add(btnExit);
        
    }
    
    private void btnRegistrationActionPerformed(){
        registration();
    }
    private void btnCleannActionPerformed(){
        clean();
    }
    private void btnNewRegistrationActionPerformed(){
        clean();
    }
    
    private void registration(){
        
        String placa, marca, modelo, cor;
        int qtdRodas, tara, potencia, qtdPist, cargaMax;
        float velocMax;
        
        try {
            placa = tfPlaca.getText();
            bdVeiculos.existentPlate(placa);
            marca = tfMarca.getText();
            modelo = tfModelo.getText();
            cor = tfCor.getText();
            if ("".equals(placa) || "".equals(marca) || "".equals(modelo) || "".equals(cor)){
                throw new EmptyTxtFieldException();
            }
            try {
                velocMax = Float.parseFloat(tfVelocMax.getText());
                if(velocMax <80 || velocMax>110){
                    throw new VelocException();
                }        
            } catch (VelocException ve) {
                velocMax = 90;
                JOptionPane.showMessageDialog(null, ve.getMessage(), "Cadastro Carga", JOptionPane.INFORMATION_MESSAGE);
              }
            qtdRodas = Integer.parseInt(tfQtdRodas.getText());
            tara = Integer.parseInt(tfTara.getText());
            cargaMax = Integer.parseInt(tfCargaMax.getText());
            qtdPist = Integer.parseInt(tfQtdPistoes.getText());
            potencia = Integer.parseInt(tfPotencia.getText());
            Carga carga = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, tara, cargaMax, potencia, qtdPist);
            bdVeiculos.addVeiculoCarga(carga);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!","Cadastro Carga", JOptionPane.INFORMATION_MESSAGE);
        } catch (VeicExistException vee) {
            JOptionPane.showMessageDialog(null, vee.getMessage(),"Cadastro Carga", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Operação não realizada!\nDados informados não são validos e/ou estão em brancos.", 
                         "Cadastro Carga", JOptionPane.ERROR_MESSAGE);
        }catch (EmptyTxtFieldException etfe){
            JOptionPane.showMessageDialog(null, etfe.getMessage(),"Cadastro Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private void clean(){
       tfTara.setText("");
       tfCargaMax.setText("");
       tfPlaca.setText("");
       tfMarca.setText("");
       tfModelo.setText("");
       tfCor.setText("");
       tfQtdRodas.setText("");
       tfVelocMax.setText("");
       tfQtdPistoes.setText("");
       tfPotencia.setText("");
    }
          
}
