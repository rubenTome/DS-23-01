package e4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficJunctionTest {

    @Test
    void mainTest() {
        TrafficJunction tj = new TrafficJunction();
        // GREEN
        assertEquals("[NORTH: GREEN 0][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // G0
        tj.timesGoesBy();
        assertEquals("[NORTH: GREEN 1][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // G1
        tj.timesGoesBy();
        assertEquals("[NORTH: GREEN 2][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // G2
        for (int i = 3; i <= 15; i++) tj.timesGoesBy();
        assertEquals("[NORTH: GREEN 15][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // G15

        // AMBER
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 0][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A0
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 1][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A1
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 2][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A2
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 3][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A3
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 4][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A4
        tj.timesGoesBy();
        assertEquals("[NORTH: AMBER OFF 5][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // A5

        // GREEN SOUTH
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: GREEN 0][EAST: RED][WEST: RED]", tj.toString()); // G0
        for (int i = 1; i <= 15; i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: GREEN 15][EAST: RED][WEST: RED]", tj.toString()); // G15
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: AMBER OFF 0][EAST: RED][WEST: RED]", tj.toString()); // A0

        /*Casos añadidos*/
        for(int i = 1; i <= 5; i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: AMBER OFF 5][EAST: RED][WEST: RED]", tj.toString());
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: GREEN 0][WEST: RED]", tj.toString());
        for(int i = 1; i <= 15;i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: GREEN 15][WEST: RED]", tj.toString());
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: AMBER OFF 0][WEST: RED]", tj.toString());
        for(int i = 1; i <= 5; i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: AMBER OFF 5][WEST: RED]", tj.toString());
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: RED][WEST: GREEN 0]", tj.toString());
        for(int i = 1; i <= 15; i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: RED][WEST: GREEN 15]", tj.toString());
        tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: RED][WEST: AMBER OFF 0]", tj.toString());
        for(int i = 1; i <= 5; i++) tj.timesGoesBy();
        assertEquals("[NORTH: RED][SOUTH: RED][EAST: RED][WEST: AMBER OFF 5]", tj.toString());
        tj.timesGoesBy();
        assertEquals("[NORTH: GREEN 0][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString());

        tj.amberJunction(true);
        assertEquals("[NORTH: AMBER ON][SOUTH: AMBER ON][EAST: AMBER ON][WEST: AMBER ON]", tj.toString()); // amber blinking (no time)
        for (int i = 1; i <= 10; i++) tj.timesGoesBy();
        assertEquals("[NORTH: AMBER ON][SOUTH: AMBER ON][EAST: AMBER ON][WEST: AMBER ON]", tj.toString()); // amber blinking (no time)
        tj.amberJunction(false);
        assertEquals("[NORTH: GREEN 0][SOUTH: RED][EAST: RED][WEST: RED]", tj.toString()); // north green
    }
}