package e1;

public class Timer implements ModoFun {
    private boolean primeraVez = true;

    private static final Timer instancia = new Timer();

    public static Timer getInstancia() {
        return instancia;
    }

    public void timer(Termostato termostato, int time) {
        if (primeraVez) {
            termostato.setEncendido(true);
            primeraVez = false;
            termostato.setTime(time);
            termostato.setLog("Se activa el modo timer " + time + " minutos\n");
        } else {
            if (termostato.getTime() > 0) {
                termostato.setLog(termostato.getCurrentTemperature() + " Modo Timer (faltan " + termostato.getTime()
                        + " minutos) - calefacción encendida\n");
            } else {
                termostato.setEncendido(false);
                primeraVez = true;
                termostato.setTime(0);
                termostato.setLog("Se desactiva el modo timer\n");
                termostato.apagar();
            }
        }
    }

    public void screenInfo(Termostato termostato) {
        System.out.println(termostato.getCurrentTemperature() + " ON T " + termostato.getTime() + "\n");
    }
}
