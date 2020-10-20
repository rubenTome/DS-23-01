package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {

    @Test
    void constructorasClock() {
        try {//casos suponemos correctos
            new Clock("12:25:36");
            new Clock("12:01:12 AM");
            new Clock("12:01:12 PM");
            new Clock(12, 25, 37, Clock.Period.AM);
            new Clock(12, 25, 0);
        } catch (IllegalArgumentException exception) {
            assert false;
        }

        try {//caso suponemos falso
            new Clock("12:25:36AM");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("12:25:36 ww");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("12/25/36 AM");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("AB:CD:DE");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("90:56:30");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("12:61:30");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("12:59:60");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock("05:14:25AAM");
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock(61, 50, 3);
        } catch (IllegalArgumentException exception) {
            assert true;
        }try {//caso suponemos falso
            new Clock(12, 62, 15);
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock(9, 8, 60);
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock(61, 50, 3, Clock.Period.PM);
        } catch (IllegalArgumentException exception) {
            assert true;
        }try {//caso suponemos falso
            new Clock(12, 62, 15, Clock.Period.AM);
        } catch (IllegalArgumentException exception) {
            assert true;
        }
        try {//caso suponemos falso
            new Clock(9, 8, 60, Clock.Period.NULL);
        } catch (IllegalArgumentException exception) {
            assert true;
        }
    }

    @Test
    void gettersClock() {
        Clock clock = new Clock("03:25:45 PM");
        Clock clock2 = new Clock("22:15:04");
        assertEquals(Clock.Period.PM.getVal(), clock.getPeriod().getVal());
        assertEquals(clock.getHours24(), 15);
        assertEquals(clock.getHours12(), 3);
        assertEquals(clock.getMinutes(), 25);
        assertEquals(clock.getSeconds(), 45);
        assertEquals(clock2.getHours24(), 22);
        assertEquals(clock2.getHours12(), 10);
    }

    @Test
    void printClock() {
        Clock clock = new Clock("03:25:45 PM");
        Clock clock2 = new Clock("10:10:10 AM");
        assertEquals(clock.printHour24(), "15:25:45");
        assertEquals(clock2.printHour24(), "10:10:10");
        assertEquals(clock.printHour12(), "03:25:45 PM");
    }

    @Test
    void compClock() {
        Clock clock = new Clock("11:25:45 PM");
        Clock clock2 = new Clock("23:25:45");
        assertEquals(clock.hashCode(), clock2.hashCode());
        assertEquals(clock2, clock);
        assertEquals(clock, clock2);
        assertEquals(clock, clock);
    }
}