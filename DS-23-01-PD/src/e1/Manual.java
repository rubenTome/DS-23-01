package e1;

public class Manual implements ModoFun {
    private static final Manual instancia = new Manual();
    public static Manual getInstancia() {
        return instancia;
    }
    public void manual(Termostato termostato) {
        termostato.setTime(0);
        termostato.setEncendido(true);
        Timer.getInstancia().setPrimeraVez(true);
        Program.getInstancia().setPrimeraVez(true);
        termostato.setLog("Modo manual - Calefacción encendida\n");
    }

    public String screenInfo(Termostato termostato) {
        return (termostato.getCurrentTemperature() + " ON M\n");
    }
}