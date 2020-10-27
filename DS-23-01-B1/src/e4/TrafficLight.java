package e4;

public enum TrafficLight {
    NORTH("NORTH", "GREEN", 0),
    SOUTH("SOUTH", "RED", 0),
    EAST("EAST", "RED", 0),
    WEST("WEST", "RED", 0);

    private final String name;
    private String state;
    private int counter;

    TrafficLight(final String name, String state, int counter){
        this.name = name;
        this.state = state;
        this.counter = counter;
    }

    public String getName(){
        return name;
    }

    public String getState(){
        return state;
    }

    public int getCounter(){
        return counter;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }
}
