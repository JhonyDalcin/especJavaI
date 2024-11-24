/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.javai.cadastrarveiculos;

import java.util.List;

/**
 *
 * @author jhonydalcin
 */
public class Teste {
    
    static BDVeiculos bd = new BDVeiculos();
    static Leitura l = new Leitura();

    public static void main(String[] args) {
                    
        boolean keepRunning = true;
        int option;
        
        while (keepRunning) {
            
            System.out.println("""
                               
                               Sistema de Gestao de Veiculos - Menu Inicial
                               
                                1. Cadastrar Veiculo de Passeio
                                2. Cadastrar Veiculo de Carga
                                3. Imprimir Todos os Veiculos de Passeio
                                4. Imprimir Todos os Veiculos de Carga
                                5. Imprimir Veiculo de Passeio pela Placa
                                6. Imprimir Veiculo de Carga pela Placa
                                7. Excluir Veiculo de Passeio pela Placa
                                8. Excluir Veiculo de Carga pela Placa
                                9. Sair do sistema
                               """);
            
            try {
                    option = Integer.parseInt(l.dataEnter("Escolha uma opcao: "));
            } 
            catch (NumberFormatException e) {
                System.out.println("\n!!!Deve ser apenas um numero, conforme valor do item no menu!!!");
                endMenuFunctionCleanning();
                continue;
            }
            
            switch(option){
                
                case 1:
                    boolean continueRegistering = false;
                    do{
                        Passeio passeio = new Passeio();
                        boolean validRegistrationData = passeioRegistration(passeio);
                        if (validRegistrationData){
                            bd.addVeiculoPasseio(passeio);
                            System.out.println("\nVeiculo de passeio registrado com sucesso!");
                        } else {
                            System.out.println("\nErro na entrada de dados de registro. Veiculo passeio NAO registrado!");
                            }
                        continueRegistering = continueRegisteringValidation();
                    } while (continueRegistering);                    
                    break;
                    
                    
                case 2:
                    continueRegistering = false;
                    do {
                        Carga carga = new Carga();
                        boolean validRegistrationData = cargaRegistration(carga);
                        if (validRegistrationData){
                            bd.addVeiculoCarga(carga);
                            System.out.println("\nVeiculo de carga registrado com sucesso!");                            
                        } else {
                            System.out.println("\nErro na entrada de dados de registro. Veiculo carga NAO registrado!");
                            }
                        continueRegistering = continueRegisteringValidation();
                    } while (continueRegistering);
                    break;
                    
                case 3:
                    List<Passeio> listPasseio = bd.getListPasseio();
                    if (listPasseio != null){
                        for (Passeio p : listPasseio){
                            System.out.println("\n");
                            p.printInfo();
                        }
                    }else {
                        System.out.println("\nNenhum veiculo de passeio registrado!");
                    }
                    endMenuFunctionCleanning();
                    break;
                        
                case 4:
                    List<Carga> listCarga = bd.getListCarga();
                    if (listCarga != null) {
                        for (Carga c: listCarga){
                            System.out.println("\n");
                            c.printInfo();
                        }
                    }else {
                        System.out.println("\nNenhum veiculo de carga registrado!");
                    }
                    endMenuFunctionCleanning();
                    break;
                    
                case 5:
                    String platePasseio = plateEntry();
                    Passeio p = bd.printPasseioByPlate(platePasseio);
                    if (p != null){
                        System.out.println("\n");
                        p.printInfo();
                    }else {
                        System.out.println("\n\nPlaca do veiculo de passeio informada, nao registrada!");
                    }
                    endMenuFunctionCleanning();
                    break;
                    
                case 6:
                    String plateCarga = plateEntry();
                    Carga c = bd.printCargaByPlate(plateCarga);
                    if (c != null){
                        System.out.println("\n");
                        c.printInfo();
                    }else {
                        System.out.println("\n\nPlaca do veiculo de carga informada, nao registrada!");
                    }                   
                    endMenuFunctionCleanning();
                    break;
                
                case 7:
                    String plate = plateEntry();
                    System.out.println((bd.removeVeiculoPasseio(plate)) ? "\nVeiculo de passeio removido com sucesso!" : "\nPlaca nao encontrada!");
                    endMenuFunctionCleanning();
                    break;

                case 8:
                    plate = plateEntry();
                    System.out.println((bd.removeVeiculoCarga(plate)) ? "\nVeiculo de carga removido com sucesso!" : "\nPlaca nao encontrada!");
                    endMenuFunctionCleanning();
                    break;
                    
                case 9:
                    keepRunning = false;
                    break;
                    
                default:
                    System.out.println("\nVoce selecionou: "+ option + "\nPor gentileza selecione uma opcao valida.");
                    endMenuFunctionCleanning();
                    break;
            }            
        }      
    }
    
        public static String plateEntry(){
        String plate = l.dataEnter("Digite a placa: ");
        return plate;
    }
        
    public static boolean passeioRegistration (Passeio p){
        
        String placa = plateEntry();
        
        //validation of existent plate
        try {
            bd.existentPlate(placa);
        } catch (VeicExistException e){
            return false;
        }
        p.setPlaca(placa);
        p.setMarca(l.dataEnter("Digita a marca: "));
        p.setModelo(l.dataEnter("Digita o modelo: "));
        p.setCor(l.dataEnter("Digita a cor: "));
        float velocMax = Float.parseFloat(l.dataEnter("Digita a velocidade maxima: "));
        try {
            if (velocMax < 80 || velocMax > 110){
                throw new VelocException();
            }else {
                p.setVelocMax(velocMax);
            }
        } catch (VelocException e) {
            p.setVelocMax(100);
            System.out.println("Velocidade maxima atribuida automaticamente: " + p.getVelocMax()+ " km/h\n" );
        }
        try {
            p.setQtdRodas(Integer.parseInt(l.dataEnter("Digita a quantidade de rodas: ")));
            p.getMotor().setQtdPist(Integer.parseInt(l.dataEnter("Digita a quantidade de pistao: ")));
            p.getMotor().setPotencia(Integer.parseInt(l.dataEnter("Digita a potencia: ")));
            p.setQtdPassageiros(Integer.parseInt(l.dataEnter("Digita a quantidade de passageiros: ")));
        } catch (NumberFormatException nfe) {
            nfe.toString();
            System.out.println("O ultimo valor entrado deve ser do tipo numero, inteiro!");
            return false;
        }
        return true;   
    }
        
    public static boolean cargaRegistration (Carga c){
        
        String placa = plateEntry();    
        //validation of existent plate
        try {
            bd.existentPlate(placa);
        } catch (VeicExistException e) {
            return false;
        }
        c.setPlaca(placa);
        c.setMarca(l.dataEnter("Digita a marca: "));
        c.setModelo(l.dataEnter("Digita o modelo: "));
        c.setCor(l.dataEnter("Digita a cor: "));
        float velocMax = Float.parseFloat(l.dataEnter("Digita a velocidade maxima: "));
        try { 
            if (velocMax < 80 || velocMax > 110){
                throw new VelocException();
            }else {
                c.setVelocMax(velocMax);
            }                
        } catch (VelocException e) {
            c.setVelocMax(90);
            System.out.println("Velocidade maxima atribuida automaticamente: " + c.getVelocMax()+ " km/h\n" );
        }
        try {
            c.setQtdRodas(Integer.parseInt(l.dataEnter("Digita a quantidade de rodas: ")));
            c.getMotor().setQtdPist(Integer.parseInt(l.dataEnter("Digita a quantidade de pistao: ")));
            c.getMotor().setPotencia(Integer.parseInt(l.dataEnter("Digita a potencia: ")));
            c.setTara(Integer.parseInt(l.dataEnter("Digita a tara: ")));
            c.setCargaMAx(Integer.parseInt(l.dataEnter("Digita a carga maxima: ")));
        } catch (NumberFormatException nfe) {
            nfe.toString();
            System.out.println("\nO ultimo valor entrado deve ser do tipo numero, inteiro!");
            return false;
        }
        return true;
    }
    
    public static boolean continueRegisteringValidation () {
        boolean newRegistration = false; 
        boolean askAgain = true;
        while (askAgain){
            String repeat = l.dataEnter("\nDeseja cadastrar mais um veiculo? <s/n> ");
            if (repeat.equalsIgnoreCase("s")){
                askAgain = false;
                newRegistration = true;
            }
            else if (repeat.equalsIgnoreCase("n")) {
                askAgain = false;
            }
            else {
                System.out.println("Escolha S para cadastrar novo veiculo ou N para retornar ao menu principal.");
            }
        }
        return newRegistration;    
    } 
    
    public static void endMenuFunctionCleanning(){
        System.out.println("\n------------------------------------------");
        System.out.println("\nPressione qualquer tecla para continuar...");
        l.dataEnter("");
        System.out.println("\n\n");

    }  

}
