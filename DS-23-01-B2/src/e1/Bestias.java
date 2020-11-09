package e1;

public class Bestias extends Character{
    @Override
    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setShield(int shield) {
        this.shield = shield;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public int getShield() {
        return this.shield;
    }

    public int decidirAtaque(int dado){
        return dado;
    }

    public void calcularDammage(int ataque){
        if(ataque > this.getShield()) this.setLife(ataque - this.getShield());
    }
}
