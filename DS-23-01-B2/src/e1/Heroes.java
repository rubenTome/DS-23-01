package e1;

public class Heroes extends Character{

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
}
