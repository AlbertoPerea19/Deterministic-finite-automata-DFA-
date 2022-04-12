package Controlador;

import Automata.FDA;
import Automata.Machine;
import Automata.Transition;
import Exception.MachineException;
import java.util.List;


public class JAfdController {
    private static final JAfdController INSTANCE = new JAfdController();
    private Machine machine;

    private JAfdController() {}  
    
    public static JAfdController getInstance() {
        return INSTANCE;
    }
    
    public void newDFA(){
        this.machine = new FDA();
    }
    
    public void enteralfabeto(String[] alfabeto) throws MachineException {
        this.machine.createAlfabeto(alfabeto);
    }
    
    public void enterestados(int numberOfestados) {
        this.machine.addEstados(numberOfestados);
    }
    
    public void enterFinalestados(String[] finalestados) throws MachineException{
        this.machine.addFinalEstados(finalestados);       
    }
    
    public void newTransition(int currentState, String currentSymbol, int nextState) throws MachineException {
        this.machine.newTransition(currentState, currentSymbol, nextState);
    }
    
    public String simulate(String word) throws MachineException {
        return machine.simulate(word);
    }

    public Machine getCurrentMachine() {
        return machine;
    }
    
    public String getalfabeto() {
        return machine.getAlfabeto().toString();
    }
    
    public String getestados() {
        return machine.getEstados().toString();
    }
    
    public String getFinalestados() {
        return machine.getFinalEstados().toString();
    }
    
    public List<Transition> getTransitions() {
        return machine.gettransiciones();
    }
    
    public int getNumberOfestados() {
        return machine.getEstados().size();
    }
    
    public Object[] getSymbols() {
        return machine.getAlfabeto().getSymbols().values().toArray();
    }
}
