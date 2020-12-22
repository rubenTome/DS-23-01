package e1;

public class Termostato {
    private boolean encendido;
    private final StringBuilder log = new StringBuilder();
    private float currentTemperature;
    private int time;
    private ModoFun modo = Off.getInstancia();

    public void newTemperature(float currentTemperature) {
        this.currentTemperature = currentTemperature;
        time -= 5;
        if (time < 0)
            time = 0;
    }

    public String screenInfo() {
       return modo.screenInfo(this);
    }

    public void manual() {
        this.setModo(Manual.getInstancia());
        modo.manual(this);
    }

    public void apagar() {
        this.setModo(Off.getInstancia());
        modo.apagar(this);
    }

    public void timer(int time) {
        if (!(this.modo instanceof Program)) {
            this.setModo(Timer.getInstancia());
            modo.timer(this, time);
        }
        else
            setLog("No se puede cambiar a timer\n");
    }

    public void program(float temperature) {
        if (!(this.modo instanceof Timer)) {
            this.setModo(Program.getInstancia());
            modo.program(this, temperature);
        }
        else
            setLog("No se puede cambiar a program\n");
    }

    private void setModo(ModoFun modo) {
        this.modo = modo;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean getEncendido() {
        return encendido;
    }

    public void setLog(String s) {
        log.append(s);
    }

    public StringBuilder getLog() {
        return log;
    }

    public float getCurrentTemperature() {
        return currentTemperature;
    }


}