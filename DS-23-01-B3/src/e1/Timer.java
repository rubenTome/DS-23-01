package e1;

public class Timer implements modoFun {
    private boolean primeraVez = true;

    private static final Timer instancia = new Timer();

    public static Timer getInstancia() {
        return instancia;
    }

    public void funcionar(Termostato termostato, int time) {
        if (termostato.getConflicto() != 2) {
            if (primeraVez) {
                termostato.setConflicto(1);
                termostato.setEncendido(true);
                primeraVez = false;
                termostato.setTime(time);
                termostato.setLog("Se activa el modo timer " + time + " minutos\n");
                termostato.setTime(termostato.getTime() - 5);
                if (termostato.getTime() < 0)//duda
                    termostato.setTime(0);
            } else {
                if (termostato.getTime() > 0) {
                    termostato.setLog(termostato.getCurrentTemperature() + " Modo Timer (faltan " + termostato.getTime()
                            + " minutos) - calefacción encendida\n");
                    termostato.setTime(termostato.getTime() - 5);
                    if (termostato.getTime() < 0)//duda
                        termostato.setTime(0);
                }
                else {
                    termostato.setEncendido(false);
                    primeraVez = true;
                    termostato.setTime(0);
                    termostato.setLog("Se desactiva el modo timer\n");
                    termostato.setModo(Off.getInstancia());
                }
            }
        } else {
            termostato.setLog("No se puede cambiar a timer\n");
            termostato.setModo(Program.getInstancia());
        }
    }

    public void screenInfo(Termostato termostato) {
        if (termostato.getEncendido()) {
            if (termostato.getTime() > 0)
                System.out.println(termostato.getCurrentTemperature() + " ON T " + termostato.getTime() + "\n");
            else
                System.out.println(termostato.getCurrentTemperature() + " OFF T " + termostato.getTime() + "\n");
        }
        else
            System.out.println(termostato.getCurrentTemperature() + " OFF T " + termostato.getTime() + "\n");
    }
}
