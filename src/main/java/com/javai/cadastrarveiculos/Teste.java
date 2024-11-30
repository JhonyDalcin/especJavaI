package com.javai.cadastrarveiculos;

import com.javai.cadastrarveiculos.gui.MainWindow;
import com.javai.cadastrarveiculos.service.BDVeiculos;

/**
 *
 * @author jhonydalcin
 */
public class Teste {
    
    BDVeiculos bdVeiculos = BDVeiculos.getInstance();  

    public static void main(String[] args) {
        MainWindow.getInstance().setVisible(true);
    }
        
}
