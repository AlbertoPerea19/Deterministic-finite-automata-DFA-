package Automata;

public class Transition {
    
    private int estadoActual;
    private int estadoSiguiente;
    private String symbol;
    
    public Transition() {}
  
    public Transition(int estadoActual, String symbol, int estadoSiguiente){
        this.estadoActual = estadoActual;
        this.symbol = symbol;
        this.estadoSiguiente = estadoSiguiente;
    }

    public int getestadoActual() {
        return estadoActual;
    }

    public int getestadoSiguiente() {
        return estadoSiguiente;
    }

    public String getsymbol() {
        return symbol;
    }    
}
