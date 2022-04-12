package Automata;

import Exception.MachineException;
import java.util.List;
import java.util.Set;

public abstract class Machine {
    protected Alfabeto alfabeto;
    protected Config Config;    
    protected List<Integer> estados;
    protected Set<Integer> estadosFinales;
    protected List<Transition> transiciones;

    public void createAlfabeto(String[] symbols) throws MachineException {
        this.alfabeto = new Alfabeto();
        this.alfabeto.addSymbols(symbols);
    }

    public void addEstados(int numberOfEstados) {
        for (int i = 0; i < numberOfEstados; i++) {
            estados.add(i);
        }
    }

    public void addFinalEstados(String[] estadosFinales) throws MachineException {
        for (String estadoFinal : estadosFinales) {
            int estadoFinalNumber = Integer.parseInt(estadoFinal);
            
            if (estadoFinalNumber > 0 && estadoFinalNumber < getEstados().size()) {
                if (belongsToEstadosCollection(estadoFinalNumber)) {
                    this.estadosFinales.add(estadoFinalNumber);
                } else {
                    throw new MachineException("Dato inválido, por favor ingrese nuevamente");
                }
            } else {
                throw new MachineException("Dato inválido, por favor ingrese nuevamente");
            }
        }
    }

    public void newTransition(int estadoActual, String symbol, int estadoSiguiente) throws MachineException {
        if (belongsToEstadosCollection(estadoSiguiente)) {
            this.transiciones.add(new Transition(estadoActual, symbol, estadoSiguiente));
        } else {
            throw new MachineException("Dato inválido, por favor ingrese nuevamente");
        }
    }

    protected boolean belongsToEstadosCollection(int state) {
        return estados.contains(state);
    }

    protected int estadoSiguiente(int currentPosition, String symbol) {        
        for (Transition transition : transiciones) {
            if (transition.getestadoActual() == currentPosition && transition.getsymbol().equals(symbol)) {
                return transition.getestadoSiguiente();
            }
        }
        return 0;
    }
    
    protected boolean aceptaPalabra(int posicionInicial) {
        return estadosFinales.contains(posicionInicial);
    }
    
    public abstract String simulate(String palabra) throws MachineException;
    
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }
    
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }
    
    public Config getConfig() {
        return Config;
    }

    public List<Integer> getEstados() {
        return estados;
    }

    public Set<Integer> getFinalEstados() {
        return estadosFinales;
    }

    public String getSymbol(int index) {        
        return alfabeto.getSymbols().get(index);
    }

    public List<Transition> gettransiciones() {
        return transiciones;
    }
}
