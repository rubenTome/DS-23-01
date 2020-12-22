package e1;

public class Off implements ModoFun {
    private static final Off instancia = new Off();

    public static Off getInstancia() {
        return instancia;
    }

    public void apagar(Termostato termostato) {
        termostato.setEncendido(false);
        Timer.getInstancia().setPrimeraVez(true);
        Program.getInstancia().setPrimeraVez(true);
        termostato.setTime(0);
        termostato.setLog(termostato.getCurrentTemperature() + " Modo Off - calefacción apagada\n");
    }

    public String screenInfo(Termostato termostato) {
        return (termostato.getCurrentTemperature() + " OFF O\n");
    }
}
