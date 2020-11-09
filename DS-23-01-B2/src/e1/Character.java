package e1;

public abstract class Character {
    String name;
    int life;
    int shield;

    public abstract String getName();
    public abstract int getLife();
    public abstract int getShield();

    public abstract void setName(String name);
    public abstract void setLife(int life);
    public abstract void setShield(int shield);

}
