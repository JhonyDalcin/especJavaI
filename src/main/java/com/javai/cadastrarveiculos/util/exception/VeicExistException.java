/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.util.exception;

/**
 *
 * @author jhony
 */
public class VeicExistException extends Exception{
    
    public VeicExistException() {
        System.out.println("\nPlaca do veiculo informada ja cadastrada!");
    }
    
}
