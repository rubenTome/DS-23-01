package e1;

public abstract class Bestias extends Character{

    public abstract String getName();
    public abstract int getLife();
    public abstract int getShield();

    public abstract void setName(String name);
    public abstract void setLife(int life);
    public abstract void setShield(int shield);

    public int decidirAtaque(int dado){
        return dado;
    }
    public abstract void calcularDammage(int ataque);
    public abstract void Atacar(int ataque, Heroes hero);
}
