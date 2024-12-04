/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.model;

import com.javai.cadastrarveiculos.service.Calcular;

/**
 *
 * @author jhonydalcin
 */
public final class Carga extends Veiculo implements Calcular {
       
    private int cargaMax;
    private int tara;

    public Carga() {
    }
    
    public Carga (String placa, String marca, String modelo, 
                    String cor, float velocMax, int qtdRodas,
                    int tara, int cargaMax, int potencia, int qtdPist){
        
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        this.tara = tara;
        this.cargaMax = cargaMax;
                 
    }
    

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMAx(int cargaMAx) {
        this.cargaMax = cargaMAx;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }
        
    @Override    
    public float calcVel(float velocMax){
        float velocMaxCmHora = velocMax *100000;   
        return velocMaxCmHora;
    }
    
    @Override
    public void printInfo(){
        
        String veiculoInfo = getVeiculoInfo();
        
        System.out.print(veiculoInfo);
        System.out.println("Velocidade Maxima: " + String.format("%,.0f",calcVel(getVelocMax())) + " cm/h");
        System.out.println("Tara: " +String.format("%,d", getTara()) + " kg");
        System.out.println("Carga Maxima: " + String.format("%,d", getCargaMax()) + " kg");
        System.out.println("Soma valores numericos: " + calcular());
        
    }
    
    @Override
    public int calcular(){
        
        int values = (int) (getQtdRodas()+
                getVelocMax()+
                getTara()+
                getCargaMax()+
                getMotor().getPotencia()+
                getMotor().getQtdPist());
        
        return values;
    }
 
}
