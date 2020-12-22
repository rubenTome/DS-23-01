package e1;

public class Program implements ModoFun {
    private float consigna;
    private boolean primeraVez = true;
    private static final Program instancia = new Program();

    public static Program getInstancia() {
        return instancia;
    }

    public void program(Termostato termostato, float temperature) {
        termostato.setTime(0);
        if (primeraVez) {
            primeraVez = false;
            consigna = temperature;
            termostato.setEncendido(true);
            termostato.setLog("Se activa el modo program a " + consigna + " grados\n");
        } else if (termostato.getCurrentTemperature() < temperature) {
            termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                    + " - Calefacción encendida\n");
        } else {
            primeraVez = true;
            termostato.setEncendido(false);
            termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                    + " - Calefacción apagada\n");
            termostato.apagar();
        }
    }

    public void setPrimeraVez(boolean primeraVez) {this.primeraVez = primeraVez;}

    public String screenInfo(Termostato termostato) {
        if (termostato.getEncendido())
            return (termostato.getCurrentTemperature() + " ON P " + consigna + "\n");
        else
            return (termostato.getCurrentTemperature() + " OFF P " + consigna + "\n");
    }
}