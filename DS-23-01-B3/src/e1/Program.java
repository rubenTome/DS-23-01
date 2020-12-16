package e1;

public class Program implements modoFun{
    private float consigna;
    private boolean primeraVez = true;
    private static final Program instancia = new Program();
    public static Program getInstancia() {
        return instancia;
    }

    public void funcionar(Termostato termostato, float temperature) {
        if ((!termostato.getModo().equals(Timer.getInstancia()))) {
            if (primeraVez)
                consigna = temperature;
            if (termostato.getCurrentTemperature() < temperature) {
                termostato.setEncendido(true);
                termostato.setLog(termostato.getCurrentTemperature() + "Modo program (a " + temperature + "grados)"
                        + " - Calefacción encendida\n");
            }
            else {
                termostato.setEncendido(false);
                primeraVez = true;
                termostato.setLog(termostato.getCurrentTemperature() + "Modo program (a " + temperature + "grados)"
                        + " - Calefacción apagada\n");
            }
        }
        else
            System.out.println("No se puede cambiar a program\n");
    }

    public void screenInfo(Termostato termostato) {
        if (termostato.getEncendido())
        System.out.println(termostato.getCurrentTemperature() + " ON P " + consigna);
        else
            System.out.println(termostato.getCurrentTemperature() + " OFF P " + consigna);
    }
}
