package e1;

public class Program implements ModoFun {
    private float consigna;
    private boolean primeraVez = true;
    private static final Program instancia = new Program();

    public static Program getInstancia() {
        return instancia;
    }

    public void program(Termostato termostato, float temperature) {
        if (primeraVez) {
            consigna = temperature;
            primeraVez = false;
            termostato.setEncendido(true);
            termostato.setLog("Se activa el modo program a " + consigna + " grados\n");
        } else if (termostato.getCurrentTemperature() < temperature) {
            termostato.setEncendido(true);
            termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                    + " - Calefacción encendida\n");
        } else {
            termostato.setEncendido(false);
            primeraVez = true;
            termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                    + " - Calefacción apagada\n");
            termostato.apagar();
        }
    }

    public void screenInfo(Termostato termostato) {
        if (termostato.getEncendido())
            System.out.println(termostato.getCurrentTemperature() + " ON P " + consigna + "\n");
        else
            System.out.println(termostato.getCurrentTemperature() + " OFF P " + consigna + "\n");
    }
}
