/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.util.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author jhony
 */
public class VelocException extends Exception {

    public VelocException() {
    }
    
    @Override
    public String getMessage(){
        return "Velocidade informada fora dos limites brasileiros!";
    }
}
