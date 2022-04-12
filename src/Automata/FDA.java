package Automata;

import Exception.MachineException;
import java.util.ArrayList;
import java.util.HashSet;


public class FDA extends Machine {
        
   
    public FDA(){
        this.estados = new ArrayList<Integer>();
        this.estadosFinales = new HashSet<Integer>();
        this.transiciones = new ArrayList<Transition>();
    }
    
    @Override
    public String simulate(String word) throws MachineException {        
        this.Config = new Config(this.alfabeto);
        this.Config.inputPalabra(word);
        this.Config.setposicionInicial(0);
        
        String currentSymbol;
        StringBuilder result = new StringBuilder();
        
        result.append("Cadena = ")
                .append(Config.getPalabra());
        
        for (int i = 0; i < Config.getPalabra().length(); i++) {
            currentSymbol = String.valueOf(Config.getPalabra().charAt(i));
            
            result.append("\n\nCaracter leído = ")
                    .append(currentSymbol)
                    .append("\nEstado Actual = q")
                    .append(Config.getposicionInicial());
            
            this.Config.setposicionInicial(estadoSiguiente(Config.getposicionInicial(), currentSymbol));
            
            result.append("\nCambia al estado q")
                    .append(Config.getposicionInicial());
        }
        
        result.append("\n\nSe terminó en el estado q")
                .append(Config.getposicionInicial());
        
        if (aceptaPalabra(Config.getposicionInicial())) {            
            result.append("\n\nCadena Aceptada\n\n");
        } else {
            result.append("\n\nCadena Rechazada\n\n");
        }
        
        return result.toString();
    }
}
