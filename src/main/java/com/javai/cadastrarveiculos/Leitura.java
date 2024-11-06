/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jhonydalcin
 */
public class Leitura {
        
    public String dataEnter(String label) {
        
        System.out.print(label);
        
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(keyboard);
        
        String ret = "";
        
        try {
            ret = buff.readLine();
        } catch (IOException e) {
            System.out.println("\n System error!");
        }
        
        return ret;
    }
   
}
