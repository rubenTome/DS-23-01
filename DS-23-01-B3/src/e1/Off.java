package e1;

public class Off implements ModoFun {
    private static final Off instancia = new Off();
    public static Off getInstancia() {
        return instancia;
    }
    public void apagar(Termostato termostato) {
        termostato.setEncendido(false);
        termostato.setTime(0);
        termostato.setLog(termostato.getCurrentTemperature() + " Modo Off - calefacción apagada\n");
    }

    public void screenInfo(Termostato termostato) {
        System.out.println(termostato.getCurrentTemperature() + " OFF O\n");
    }
}
