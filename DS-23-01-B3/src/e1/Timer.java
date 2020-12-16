package e1;

public class Timer implements modoFun {
    private int time;
    private boolean primeraVez = true;

    private static final Timer instancia = new Timer();

    public static Timer getInstancia() {
        return instancia;
    }

    public void funcionar(Termostato termostato, int time) {
        if (!termostato.getModo().equals(Program.getInstancia())) {
            if (primeraVez) {
                termostato.setEncendido(true);
                primeraVez = false;
                this.time = time;
                termostato.setLog("Se activa el modo timer " + time + " minutos\n");
                this.time -= 5;
            } else {
                if (this.time > 0) {
                    termostato.setLog(termostato.getCurrentTemperature() + " Modo Timer (faltan " + this.time
                            + " minutos) - calefacción encendida\n");
                    this.time -= 5;
                }
                else {
                    termostato.setEncendido(false);
                    primeraVez = true;
                    this.time = -1;
                    termostato.setLog("Se desactiva el modo timer\n");
                }
            }
        } else
            termostato.setLog("No se puede cambiar a timer\n");
    }

    public void screenInfo(Termostato termostato) {
        if (termostato.getEncendido())
            System.out.println(termostato.getCurrentTemperature() + " ON T " + this.time + "\n");
        else
            System.out.println(termostato.getCurrentTemperature() + " OFF T " + this.time + "\n");
    }
}
