package e1;

public class Manual implements modoFun{
    private static final Manual instancia = new Manual();
    public static Manual getInstancia() {
        return instancia;
    }
    public void funcionar(Termostato termostato) {
        termostato.setEncendido(true);
        termostato.setLog("Modo manual - Calefacción encendida\n");
    }

    public void screenInfo(Termostato termostato) {
        System.out.println(termostato.getCurrentTemperature() + " ON M\n");
    }
}
