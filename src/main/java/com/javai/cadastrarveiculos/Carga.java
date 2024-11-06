/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhonydalcin
 */
public final class Carga extends Veiculo implements Calcular {
       
    private int cargaMAx;
    private int tara;

    public Carga() {
    }

    public int getCargaMAx() {
        return cargaMAx;
    }

    public void setCargaMAx(int cargaMAx) {
        this.cargaMAx = cargaMAx;
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
        System.out.println("Carga Maxima: " + String.format("%,d", getCargaMAx()) + " kg");
        System.out.println("Soma valores numericos: " + calcular());
        
    }
    
    @Override
    public int calcular(){
        
        int values = (int) (getQtdRodas()+
                getVelocMax()+
                getTara()+
                getCargaMAx()+
                getMotor().getPotencia()+
                getMotor().getQtdPist());
        
        return values;
    }
 
}
