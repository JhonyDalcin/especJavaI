
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
    
}
