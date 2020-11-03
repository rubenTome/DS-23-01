package e1;

public abstract class Character {
    protected String name;
    protected int life = 0;
    protected int shield;

    public abstract String getName();
    public abstract int getLife();
    public abstract int getShield();

    public abstract void setName(String name);
    public abstract void setLife(int life);
    public abstract void setShield(int shield);
}
