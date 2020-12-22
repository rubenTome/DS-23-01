package e1;

public class Off implements modoFun{
    private static final Off instancia = new Off();
    public static Off getInstancia() {
        return instancia;
    }
    public void funcionar(Termostato termostato) {
        termostato.setEncendido(false);
        termostato.setTime(0);
        //termostato.setConflicto(0);
        termostato.setLog(termostato.getCurrentTemperature() + " Modo Off - calefacción apagada\n");
    }

    public void screenInfo(Termostato termostato) {
        System.out.println(termostato.getCurrentTemperature() + " OFF O\n");
    }
}
