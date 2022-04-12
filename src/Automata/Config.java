package Automata;

import Exception.MachineException;


public class Config {
    private final Alfabeto alfabeto;
    private String palabra;    
    private int posicionInicial;
    
    public Config(Alfabeto alfabeto){
        this.alfabeto = alfabeto;        
    }
    
    public void inputPalabra(String palabra) throws MachineException {        
        if(pertenece(palabra)) {            
            this.palabra = palabra;
        } else {
            throw new MachineException("Verifique la cadena ingresada");            
        }                        
    }
    
    public boolean pertenece(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (!alfabeto.belongs(palabra.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public String getPalabra() {
        return palabra;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public int getposicionInicial() {
        return posicionInicial;
    }

    public void setposicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }    
}
