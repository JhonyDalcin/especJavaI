/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhonydalcin
 */
public final class Passeio extends Veiculo implements Calcular {
        
    private int qtdPassageiros;
    
    public Passeio (){
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
    
    @Override    
    public float calcVel(float velocMax){
        float velocMaxMetrosHora = velocMax *1000;   
        return velocMaxMetrosHora;
    }
        
    @Override
    public void printInfo(){
        
        String veiculoInfo = getVeiculoInfo();
  
        System.out.print(veiculoInfo);
        System.out.println("Velocidade Maxima: " + String.format("%,.0f", calcVel(getVelocMax()) ) + " m/h");
        System.out.println("Qtd Passageiros: " + getQtdPassageiros());
        System.out.println("Numero de Caracteres: " + calcular());
        
    }
    
    @Override
    public int calcular(){
               
        int numCaracteres = getPlaca().length() +
                            getMarca().length() +
                            getModelo().length() + 
                            getCor().length();
            
        return numCaracteres;
    }
  
}
