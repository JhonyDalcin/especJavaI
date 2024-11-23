/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.javai.cadastrarveiculos;

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
                                7. Sair do sistema
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
                        int emptyPosition = bd.arrayPasseioEmptyPosition();
                        if (emptyPosition < 0){
                            System.out.println("\nVeiculo de PASSEIO, NAO registrado! Vetor esta cheio.");
                        }else {
                            Passeio passeio = new Passeio();
                            boolean validRegistrationData = passeioRegistration(passeio);
                            if (validRegistrationData){
                                bd.addVeiculoPasseio(passeio, emptyPosition);
                            } else {
                                System.out.println("\nErro na entrada de dados de registro. Veiculo passeio NAO registrado!");
                            }
                            continueRegistering = continueRegisteringValidation();
                        }
                    } while (continueRegistering);                    
                    break;
                    
                    
                case 2:
                    continueRegistering = false;
                    do {
                        int emptyPosition = bd.arrayCargaEmptyPosition();
                        if (emptyPosition < 0){
                            System.out.println("\nVeiculo de CARGA, NAO registrado! Vetor esta cheio.");
                        }else {
                            Carga carga = new Carga();
                            boolean validRegistrationData = cargaRegistration(carga);
                            if (validRegistrationData){
                                bd.addVeiculoCarga(carga, emptyPosition);
                            } else {
                                System.out.println("\nErro na entrada de dados de registro. Veiculo passeio NAO registrado!");
                            }
                            continueRegistering = continueRegisteringValidation();
                        }
                    } while (continueRegistering);
                    break;
                    
                case 3:
                    bd.printPasseios();
                    endMenuFunctionCleanning();
                    break;
                    
                    
                case 4:
                    bd.printCargas();
                    endMenuFunctionCleanning();
                    break;
                    
                case 5:
                    String platePasseio = l.dataEnter("\nDigita a placa do veiculo: ");
                    bd.printPasseioByPlate(platePasseio);
                    endMenuFunctionCleanning();
                    break;
                    
                case 6:
                    String plateCarga = l.dataEnter("\nDigita a placa do veiculo: ");
                    bd.printCargaByPlate(plateCarga);
                    endMenuFunctionCleanning();
                    break;
                case 7:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("\nVoce selecionou: "+ option + "\nPor gentileza selecione uma opcao valida.");
                    endMenuFunctionCleanning();
                    break;
            }            
        }      
    }
        
    public static boolean passeioRegistration (Passeio p){
        
        String placa = l.dataEnter("\nDigite a placa: ");
        
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
        p.setQtdRodas(Integer.parseInt(l.dataEnter("Digita a quantidade de rodas: ")));
        p.getMotor().setQtdPist(Integer.parseInt(l.dataEnter("Digita a quantidade de pistao: ")));
        p.getMotor().setPotencia(Integer.parseInt(l.dataEnter("Digita a potencia: ")));
        p.setQtdPassageiros(Integer.parseInt(l.dataEnter("Digita a quantidade de passageiros: ")));
        return true;   
    }
    
    public static boolean cargaRegistration (Carga c){
        
        String placa = l.dataEnter("\nDigite a placa: ");    
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
        c.setQtdRodas(Integer.parseInt(l.dataEnter("Digita a quantidade de rodas: ")));
        c.getMotor().setQtdPist(Integer.parseInt(l.dataEnter("Digita a quantidade de pistao: ")));
        c.getMotor().setPotencia(Integer.parseInt(l.dataEnter("Digita a potencia: ")));
        c.setTara(Integer.parseInt(l.dataEnter("Digita a tara: ")));
        c.setCargaMAx(Integer.parseInt(l.dataEnter("Digita a carga maxima: ")));
        return true;
    }
    
    public static boolean continueRegisteringValidation () {
        boolean newRegistration = false; 
        boolean askAgain = true;
        while (askAgain){
            String repeat = l.dataEnter("\nDeseja cadastrar mais um veiculo de carga? S/N ").toUpperCase();
            if (repeat.equals("S")){
                askAgain = false;
                newRegistration = true;
            }
            else if (repeat.equals("N")) {
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
