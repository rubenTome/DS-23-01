package e4;

import java.util.Set;

public class ChangeColours{
    public static void Change(Set<TrafficLight> trafficLights){
        for(TrafficLight trafficLight : trafficLights){
            if(trafficLight.getState().equals("GREEN") && trafficLight.getCounter() > 15){
                trafficLight.setState("AMBER OFF");
                trafficLight.setCounter(0);
            }
            else if(trafficLight.getState().equals("AMBER OFF") && trafficLight.getCounter() > 5){
                trafficLight.setState("RED");
                trafficLight.setCounter(0);
                switch(trafficLight.getName()){
                    case "NORTH": {
                        TrafficLight.SOUTH.setState("GREEN");
                        TrafficLight.SOUTH.setCounter(0);
                    }break;
                    case "SOUTH": {
                        TrafficLight.EAST.setState("GREEN");
                        TrafficLight.EAST.setCounter(0);
                    }break;
                    case "EAST": {
                        TrafficLight.WEST.setState("GREEN");
                        TrafficLight.WEST.setCounter(0);
                    }break;
                    case "WEST": {
                        TrafficLight.NORTH.setState("GREEN");
                        TrafficLight.NORTH.setCounter(0);
                    }break;
                }
            }
        }
    }
}