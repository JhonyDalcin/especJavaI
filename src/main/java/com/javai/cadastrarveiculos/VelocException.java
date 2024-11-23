/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhony
 */
public class VelocException extends Exception {

    public VelocException() {
        System.out.println("\nA velocidade maxima "
                            + "esta fora dos limites brasileiros.");
    }
}
