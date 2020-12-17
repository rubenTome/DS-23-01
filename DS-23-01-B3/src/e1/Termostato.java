package e1;

public class Termostato {
    private boolean encendido = false;
    private StringBuilder log =  new StringBuilder();
    private float currentTemperature;
    private int time;//esta en minutos
    private modoFun modo;

    public void newTemperature(float currentTemperature) {
        this.currentTemperature = currentTemperature;
        time -= 5;
        if (time < 0)
            time = 0;
    }

    public void screenInfo() {
        modo.screenInfo(this);
    }

    public void setModo(modoFun modo) {
        this.modo = modo;
    }

    public modoFun getModo() {
        return modo;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {this.time = time;}

    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean getEncendido() {return encendido;}

    public void setLog(String s) {
        log.append(s);
    }

    public StringBuilder getLog() {return log;}
}
