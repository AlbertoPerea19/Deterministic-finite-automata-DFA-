package Automata;

import Exception.MachineException;
import java.util.HashMap;
import java.util.Map;

public class Alfabeto {
    private final Map<String, String> caracteres;

    public Alfabeto() {
        this.caracteres = new HashMap<String, String>();
    }    

    public void addSymbols(final String[] caracteres) throws MachineException {        
        for (String caracter: caracteres) {
            if (caracter.length() == 1) {
                addSymbol(caracter.toLowerCase());
            } else {
                throw new MachineException("The length of a caracter can't be greater than 1.");
            }           
        }
    }
    
    public boolean belongs(final char caracter) {
        return caracteres.containsKey(String.valueOf(caracter));
    }    
    
    public void addSymbol(String caracter) {
        caracteres.put(caracter, caracter);
    }

    public Map<String, String> getSymbols() {
        return caracteres;
    }
    
    @Override
    public String toString() {
        return caracteres.toString();
    }

}
