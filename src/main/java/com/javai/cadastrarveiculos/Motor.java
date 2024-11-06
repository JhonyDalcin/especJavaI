/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhonydalcin
 */
public class Motor {
        
    private int qtdPist;
    private int potencia;

    public Motor() {
        qtdPist = 0;
        potencia = 0;
    }

    public Motor(int qtdPist, int potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }
    
    public int getQtdPist() {
        return qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public final void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public final void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
}
