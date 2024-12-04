
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javai.cadastrarveiculos.service;

import com.javai.cadastrarveiculos.model.Carga;
import com.javai.cadastrarveiculos.model.Passeio;
import com.javai.cadastrarveiculos.util.exception.VeicExistException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhony
 */
public class BDVeiculos {
    
    private final List<Passeio> bdPasseio = new ArrayList<>();
    private final List<Carga> bdCarga = new ArrayList<>();
    private static BDVeiculos bdVeiculosUniq; // Singleton
        
    private BDVeiculos(){
        createPasseioList();
        createCargaList();
    }
    
    public static BDVeiculos getInstance(){
        if (bdVeiculosUniq == null) {
            bdVeiculosUniq = new BDVeiculos();
        }
        return bdVeiculosUniq;
    }

    public List<Passeio> getListPasseio() {
        return bdPasseio;
    }

    public List<Carga> getListCarga() {
        return bdCarga;
    }
        
    public void addVeiculoPasseio(Passeio passeio){
        bdPasseio.add(passeio);
    }
    
    public void addVeiculoCarga(Carga carga){
        bdCarga.add(carga);
    }
    
    public boolean removeVeiculoPasseio(String plate) {
        for (Passeio p: bdPasseio){
            if (p.getPlaca().equals(plate)){
                bdPasseio.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeVeiculoCarga(String plate) {
        for (Carga c: bdCarga){
            if (c.getPlaca().equals(plate)){
                bdCarga.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public void existentPlate(String plate) throws VeicExistException {
        for (Passeio p: bdPasseio){
            if (p != null){
                if (p.getPlaca().equals(plate)){
                    throw new VeicExistException();
                }
            }
        }
        for (Carga c: bdCarga){
            if (c != null) {
                if (c.getPlaca().equals(plate)){
                    throw new VeicExistException();
                }   
            }
        }
    }

    public Passeio printPasseioByPlate (String plate){
        for (Passeio p: bdPasseio){
            if (p.getPlaca().equals(plate)){
                return p;
                }                
        }
        return null;
    }
    
    public Carga printCargaByPlate (String plate){
        for (Carga c: bdCarga){
            if (c.getPlaca().equals(plate)){
                return c;
                }                
        }
        return null;
    }
    
    public boolean deleteAllPasseio () {
        if (bdPasseio != null){
            bdPasseio.clear();
            return true;
        }
        return false;
    }
    
    public boolean deleteAllCarga () {
        
        if (bdCarga != null){
                bdCarga.clear();
                return true;
        }
        return false;
    }
    
    private void createPasseioList(){
        bdPasseio.add(new Passeio("ABC-123", "Fiat", "Palio", "Vermelho", 100, 4, 4, 90, 4));
        bdPasseio.add(new Passeio("DEF-456", "Volkswagen", "Gol", "Azul", 110, 4, 4, 100, 4));
        bdPasseio.add(new Passeio("GHI-789", "Chevrolet", "Onix", "Preto", 90, 4, 4, 88, 4));
        bdPasseio.add(new Passeio("JKL-012", "Hyundai", "HB20", "Branco", 90, 4, 4, 88, 4));
        bdPasseio.add(new Passeio("MNO-345", "Ford", "Ka", "Amarelo", 85, 4, 4, 85, 4));
    }
    
    private void createCargaList(){
        bdCarga.add(new Carga("ABC-123", "Volkswagen", "Delivery", "Azul", 100, 6, 2500, 3000, 150, 4));
        bdCarga.add(new Carga("DEF-456", "Ford", "Cargo", "Preto", 100, 6, 3000, 4000, 160, 4));
        bdCarga.add(new Carga("GHI-789", "Fiat", "Ducato", "Branco", 100, 6, 2800, 3500, 130, 4));
        bdCarga.add(new Carga("JKL-012", "Mercedes-Benz", "Sprinter", "Bege", 100, 6, 3200, 4200, 180, 4));
        bdCarga.add(new Carga("MNO-345", "Iveco", "Daily", "Vermelho", 100, 6, 2600, 3300, 140, 4));
    }
    
}
