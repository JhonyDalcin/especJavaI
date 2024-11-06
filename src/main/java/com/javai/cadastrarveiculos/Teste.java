/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.javai.cadastrarveiculos;

/**
 *
 * @author jhonydalcin
 */
public class Teste {
    
    static Leitura l = new Leitura();
    static Passeio[] arrayPasseio = new Passeio[5];
    static Carga[] arrayCarga = new Carga[5];

    public static void main(String[] args) {
                    
        boolean keepRunning = true;
        int option = 0;
        
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
                        int passeioPosition = arrayPasseioEmptyPosition(arrayPasseio);
                        if(passeioPosition < 0) {
                            System.out.println("\nNao eh possivel registrar, Vetor Passeio esta cheio!");
                        } else {
                            Passeio passeio = new Passeio();
                            if (passeioRegistration(passeio)){
                               arrayPasseio[passeioPosition] = passeio;
                                System.out.println("\nVeiculo registrado com sucesso!");
                            } else {
                                System.out.println("\nVeiculo nao registrado, placa informada ja registrada.");
                            }
                            continueRegistering = continueRegisteringValidation();
                        }
                    } while (continueRegistering);                    
                    break;
                    
                    
                case 2:
                    continueRegistering = false;
                    do {
                        int cargaPosition = arrayCargaEmptyPosition(arrayCarga);
                        if(cargaPosition < 0) {
                            System.out.println("\nNao eh possivel registrar, Vetor Carga esta cheio!");
                        }
                        else {
                            Carga carga = new Carga();
                            if (cargaRegistration(carga)){
                               arrayCarga[cargaPosition] = carga;
                               System.out.println("\nVeiculo registrado com sucesso!");
                            } else {
                                System.out.println("\nVeiculo nao registrado, placa informada ja registrada.");
                            }
                            continueRegistering = continueRegisteringValidation();
                        }    
                    } while (continueRegistering);
                    break;
                    
                    
                case 3:
                    boolean isEmpty = true;
                    for (int i = 0; i < arrayPasseio.length; i++){
                        if (arrayPasseio[i] != null){
                            System.out.println("\nImprimindo Veiculo Passeio: " + (i+1));
                            arrayPasseio[i].printInfo(); 
                            isEmpty = false;
                        }
                    }
                    System.out.println(isEmpty ? "\nNenhum veiculo de passeio registrado" : "");
                    endMenuFunctionCleanning();
                    break;
                    
                    
                case 4:
                    isEmpty = true;
                    for (int i = 0; i < arrayCarga.length; i++){
                        if (arrayCarga[i] != null){
                            System.out.println("\nImprimindo Veiculo Carga: " + (i+1));
                            arrayCarga[i].printInfo();
                            isEmpty = false;
                        }   
                    }
                    System.out.println(isEmpty ? "\nNenhum veiculo de carga registrado" : "");
                    endMenuFunctionCleanning();
                    break;
                    
                case 5:
                    String plate = l.dataEnter("\nDigita a placa do veiculo: ");
                    if (existentPlate(plate)) {
                        for (Passeio p : arrayPasseio){
                            if (p != null) {
                                if (p.getPlaca().equals(plate)){
                                    p.printInfo();
                                }                                
                            }
                        }
                    } else {
                        System.out.println("\nPlaca nao encontrada");
                    }
                    endMenuFunctionCleanning();
                    break;
                    
                    
                case 6:
                    plate = l.dataEnter("\nDigita a placa do veiculo: ");
                    if (existentPlate(plate)) {
                        for (Carga c : arrayCarga){
                            if (c != null){
                                if (c.getPlaca().equals(plate)){
                                    c.printInfo();
                                }   
                            }
                        }
                    } else {
                        System.out.println("\nPlaca nao encontrada");
                    }
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
    
    
    
    
    public static int arrayPasseioEmptyPosition(Passeio[] arrayPasseio){
        for (int i=0; i<arrayPasseio.length; i++){
            if (arrayPasseio[i] == null){
                return i;
            }    
        }
        return -1;
    }

    public static int arrayCargaEmptyPosition(Carga[] arrayCarga){
        for (int i=0; i<arrayCarga.length; i++){
            if (arrayCarga[i] == null){
                return i;
            }    
        }
        return -1;
    }

    public static boolean existentPlate(String plate) {
        for (Passeio p: arrayPasseio){
            if (p != null){
                if (p.getPlaca().equals(plate)){
                    return true;
                }
            }
        }
        for (Carga c: arrayCarga){
            if (c != null) {
                if (c.getPlaca().equals(plate)){
                    return true;
                }   
            }
        }
        return false;
    }
    
    public static boolean passeioRegistration (Passeio p){
        
        String placa = l.dataEnter("\nDigite a placa: ");
        
        //validation of existent plate
        if (existentPlate(placa)){
            return false;
        }
        
        p.setPlaca(placa);
        p.setMarca(l.dataEnter("Digita a marca: "));
        p.setModelo(l.dataEnter("Digita o modelo: "));
        p.setCor(l.dataEnter("Digita a cor: "));
        p.setVelocMax(Float.parseFloat(l.dataEnter("Digita a velocidade maxima: ")));
        p.setQtdRodas(Integer.parseInt(l.dataEnter("Digita a quantidade de rodas: ")));
        p.getMotor().setQtdPist(Integer.parseInt(l.dataEnter("Digita a quantidade de pistao: ")));
        p.getMotor().setPotencia(Integer.parseInt(l.dataEnter("Digita a potencia: ")));
        p.setQtdPassageiros(Integer.parseInt(l.dataEnter("Digita a quantidade de passageiros: ")));
        return true;
    }
    
    public static boolean cargaRegistration (Carga c){
        
        String placa = l.dataEnter("\nDigite a placa: ");
        
        //validation of existent plate
        if (existentPlate(placa)){
            return false;
        }
        
        c.setPlaca(placa);
        c.setMarca(l.dataEnter("Digita a marca: "));
        c.setModelo(l.dataEnter("Digita o modelo: "));
        c.setCor(l.dataEnter("Digita a cor: "));
        c.setVelocMax(Float.parseFloat(l.dataEnter("Digita a velocidade maxima: ")));
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
