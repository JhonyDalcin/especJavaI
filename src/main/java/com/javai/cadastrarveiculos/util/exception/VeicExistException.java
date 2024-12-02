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
public class VeicExistException extends Exception{
    
    public VeicExistException() {
    }
    
    @Override
    public String getMessage(){
        return "Placa informada EXISTENTE!\nOperação não realizada!";
    }
    
}
