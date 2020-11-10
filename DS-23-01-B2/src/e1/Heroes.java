package e1;

public abstract class Heroes extends Character{

    public abstract String getName();
    public abstract int getLife();
    public abstract int getShield();

    public abstract void setName(String name);
    public abstract void setLife(int life);
    public abstract void setShield(int shield);
    public int decidirAtaque(int dado1, int dado2){
        return Math.max(dado1, dado2);
    }
    public abstract void calcularDammage(int ataque);

    public abstract void Atacar(int ataque, Bestias bestia);

}
