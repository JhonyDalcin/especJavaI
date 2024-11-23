/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhonydalcin
 */
public abstract class Veiculo {
        
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        placa = "";
        marca = "";
        modelo = "";
        cor = "";
        velocMax = 0;
        qtdRodas = 0;
        motor = new Motor();
    }

    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = new Motor(qtdPist, potencia);
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }
    
    protected final void setVelocMax(float velocMax){
        this.velocMax = velocMax;
    }
        

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    public abstract float calcVel(float velocMax);
    
    public abstract void printInfo();
    
    public String getVeiculoInfo() {
        return "Marca: " + getMarca() + "\n" +
               "Modelo: " + getModelo()+ "\n" +
               "Cor: " + getCor() + "\n" +
               "Velocidade Maxima: " + getVelocMax()+ " km/h\n" +
               "Placa: " + getPlaca()+ "\n" +
               "Potencia do Motor: " + getMotor().getPotencia()+ " HP" + "\n" +
               "Qtd Pistoes Motor: " + getMotor().getQtdPist()+ "\n";
    }
   
}
