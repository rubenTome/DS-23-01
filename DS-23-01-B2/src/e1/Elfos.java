package e1;

public class Elfos extends Heroes{
    public Elfos(String name, int life, int shield){
        setName(name);
        setLife(life);
        setShield(shield);
    }

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

    public void calcularDammage(int ataque){
        if(ataque > this.getShield()) this.setLife(this.getLife() - (ataque - this.getShield()));
    }

    @Override
    public void Atacar(int ataque, Bestias bestia) {
        bestia.calcularDammage(ataque);
    }
}
