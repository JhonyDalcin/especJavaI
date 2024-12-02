/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.util.exception;

/**
 *
 * @author jhony
 */
public class EmptyTxtFieldException extends Exception {
    
    public EmptyTxtFieldException(){
    }
    
    @Override
    public String getMessage(){
        return "Todos os campos devem ser preenchidos!";
    }
    
}
