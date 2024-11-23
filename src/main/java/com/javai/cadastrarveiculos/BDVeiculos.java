
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos;

/**
 *
 * @author jhony
 */
public class BDVeiculos {
    
    static Passeio[] arrayPasseio = new Passeio[5];
    static Carga[] arrayCarga = new Carga[5];
    
    public BDVeiculos(){
    }

    public static Passeio[] getArrayPasseio() {
        return arrayPasseio;
    }

    public static Carga[] getArrayCarga() {
        return arrayCarga;
    }
    
    public void printPasseios (){
        if (arrayPasseioEmptyPosition() == 0){
            System.out.println("Nenhum veiculo PAASEIO registrado!");
        }
        for (Passeio p : arrayPasseio){
            if (p != null) {
                p.printInfo();
            }
        }
    }
    
    public void printCargas (){
        if (arrayCargaEmptyPosition() == 0){
            System.out.println("\nNenhum veiculo PAASEIO registrado!");
        }
        for (Carga c : arrayCarga){
            if (c != null){
                c.printInfo();
            }
        }
    }
    
    public void addVeiculoPasseio(Passeio passeio, int position){
            arrayPasseio[position] = passeio;
            System.out.println("\nVeiculo PASSEIO cadastrado com sucesso!");
    }
    
    public void addVeiculoCarga(Carga carga, int position){
            arrayCarga[position] = carga;
            System.out.println("\nVeiculo CARGA cadastrado com sucesso!");
    }
    
    public int arrayPasseioEmptyPosition() {
        for(int i=0; i<arrayPasseio.length; i++){
            if (arrayPasseio[i] == null){
                return i;
            }
        }
        return -1;         
    }
    
    public int arrayCargaEmptyPosition() {
        for(int i=0; i<arrayCarga.length; i++){
            if (arrayCarga[i] == null){
                return i;
            }
        }
        return -1;         
    }
    
    
    public void existentPlate(String plate) throws VeicExistException {
        for (Passeio p: arrayPasseio){
            if (p != null){
                if (p.getPlaca().equals(plate)){
                    throw new VeicExistException();
                }
            }
        }
        for (Carga c: arrayCarga){
            if (c != null) {
                if (c.getPlaca().equals(plate)){
                    throw new VeicExistException();
                }   
            }
        }
    }

    public void printPasseioByPlate (String plate){
        boolean plateFound = false;
        for (Passeio p: arrayPasseio){
            if (p != null){
                if (p.getPlaca().equals(plate)){
                    plateFound = true;
                    p.printInfo();
                }                
            }
        }
        if (!plateFound){
            System.out.println("Placa de veiculo de PASSEIO informada não registrada");
        }
    }
    
    public void printCargaByPlate (String plate){
        boolean plateFound = false;
        for (Carga c: arrayCarga){
            if (c != null) {
                if (c.getPlaca().equals(plate)){
                    plateFound = true;
                    c.printInfo();
                }                
            }
        }
        if (!plateFound){
            System.out.println("Placa de veiculo de CARGA informada não registrada");
        }
    }
    
}
