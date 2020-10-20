package e4;

import java.util.EnumSet;
import java.util.Set;

public class TrafficJunction {
    Set<TrafficLight> Semaforos = EnumSet.allOf(TrafficLight.class);

    public TrafficJunction(){
        TrafficLight t1 = TrafficLight.NORTH;
        TrafficLight t2 = TrafficLight.SOUTH;
        TrafficLight t3 = TrafficLight.EAST;
        TrafficLight t4 = TrafficLight.WEST;
    }

    public void timesGoesBy(){
        int contador;
        for(TrafficLight trafficLight : Semaforos){
            contador = trafficLight.getCounter();
            if(trafficLight.getState().equals("GREEN") || trafficLight.getState().equals("AMBER OFF")){
                trafficLight.setCounter(contador + 1);
            }
        }
    }

    public void amberJunction(boolean active){
        if(active){
            for(TrafficLight trafficLight : Semaforos){
                trafficLight.setState("AMBER ON");
                trafficLight.setCounter(0);
            }
        }
        else{
            for(TrafficLight trafficLight : Semaforos){
                if(trafficLight.getName().equals("NORTH")){
                    trafficLight.setState("GREEN");
                }
                else{
                    trafficLight.setState("RED");
                }
                trafficLight.setCounter(0);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        for(TrafficLight trafficLight : Semaforos){
            output.append("[");
            switch(trafficLight.getState()){
                case "RED" :{
                    output.append(trafficLight.getName());
                    output.append(":");
                    output.append(trafficLight.getState());
                }
                case "GREEN" :{
                    output.append(trafficLight.getName());
                    output.append(":");
                    output.append(trafficLight.getState());
                    output.append(trafficLight.getCounter());
                }
                case "AMBER ON" :{
                    output.append(trafficLight.getName());
                    output.append(":");
                    output.append(trafficLight.getState());
                }
                case "AMBER OFF" :{
                    output.append(trafficLight.getName());
                    output.append(":");
                    output.append(trafficLight.getState());
                    output.append(trafficLight.getCounter());
                }
            }
            output.append("]");
        }
        return output.toString();
    }


}
