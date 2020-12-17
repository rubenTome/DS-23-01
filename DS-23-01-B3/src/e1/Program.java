package e1;

public class Program implements modoFun{
    private float consigna;
    private boolean primeraVez = true;
    private static final Program instancia = new Program();
    public static Program getInstancia() {
        return instancia;
    }

    public void funcionar(Termostato termostato, float temperature) {
        if (termostato.getConflicto() != 1) {
            if (primeraVez) {
                consigna = temperature;
                primeraVez = false;
                termostato.setConflicto(2);
            }
            else if (termostato.getCurrentTemperature() < temperature) {
                termostato.setEncendido(true);
                termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                        + " - Calefacción encendida\n");
            }
            else {
                termostato.setEncendido(false);
                primeraVez = true;
                termostato.setLog(termostato.getCurrentTemperature() + " Modo program (a " + temperature + " grados)"
                        + " - Calefacción apagada\n");
                termostato.setModo(Off.getInstancia());
            }
        }
        else {
            System.out.println("No se puede cambiar a program\n");
            termostato.setModo(Timer.getInstancia());
        }
    }

    public void screenInfo(Termostato termostato) {
        if (termostato.getEncendido())
        System.out.println(termostato.getCurrentTemperature() + " ON P " + consigna + "\n");
        else
            System.out.println(termostato.getCurrentTemperature() + " OFF P " + consigna + "\n");
    }
}
