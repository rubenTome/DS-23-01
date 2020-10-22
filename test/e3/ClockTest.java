package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void stringConstructors() {
        Clock c = new Clock("13:18:05");
        assertEquals( 1, c.getHours12());
        assertEquals(13, c.getHours24());
        assertEquals(18, c.getMinutes());
        assertEquals( 5, c.getSeconds());
        assertEquals(Clock.Period.PM, c.getPeriod());

        c = new Clock("05:30:00 PM");
        assertEquals( 5, c.getHours12());
        assertEquals(17, c.getHours24());
        assertEquals(30, c.getMinutes());
        assertEquals( 0, c.getSeconds());
        assertEquals(Clock.Period.PM, c.getPeriod());

        c = new Clock("12:00:00 AM");
        assertEquals(12, c.getHours12());
        assertEquals( 0, c.getHours24());
        assertEquals( 0, c.getMinutes());
        assertEquals( 0, c.getSeconds());
        assertEquals(Clock.Period.AM, c.getPeriod());

        assertThrows(IllegalArgumentException.class, () -> new Clock("Hola Mundo"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("AB:CD:EF"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("28:15:40"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("12:00:00 FM"));

        //añadidos----------------------------------------------------------------------
        c = new Clock("10:10:10");
        assertEquals(c.getPeriod(), Clock.Period.AM);
        assertThrows(IllegalArgumentException.class, () -> new Clock("12/25:45"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("12:25/45"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("12:61:12"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("12:12:64"));
        assertThrows(IllegalArgumentException.class, () -> new Clock("10:05:10_AM"));

    }

    @Test
    void integerConstructors() {
        Clock c = new Clock(17, 25, 32);
        assertEquals( 5, c.getHours12());
        assertEquals(17, c.getHours24());
        assertEquals(25, c.getMinutes());
        assertEquals(32, c.getSeconds());
        assertEquals(Clock.Period.PM, c.getPeriod());

        c = new Clock(11, 30, 45, Clock.Period.PM);
        assertEquals(11, c.getHours12());
        assertEquals(23, c.getHours24());
        assertEquals(30, c.getMinutes());
        assertEquals(45, c.getSeconds());
        assertEquals(Clock.Period.PM, c.getPeriod());

        c = new Clock(12, 0, 0, Clock.Period.AM);
        assertEquals(12, c.getHours12());
        assertEquals( 0, c.getHours24());
        assertEquals( 0, c.getMinutes());
        assertEquals( 0, c.getSeconds());
        assertEquals(Clock.Period.AM, c.getPeriod());

        //añadidos-----------------------------------
        c = new Clock(10, 10, 10);
        assertEquals(c.getPeriod(), Clock.Period.AM);
        assertThrows(IllegalArgumentException.class, () -> new Clock(24, 10, 10));
        assertThrows(IllegalArgumentException.class, () -> new Clock(22, 60, 10));
        assertThrows(IllegalArgumentException.class, () -> new Clock(20, 10, 61));
        assertThrows(IllegalArgumentException.class, () -> new Clock(24, 10, 10, Clock.Period.AM));
        assertThrows(IllegalArgumentException.class, () -> new Clock(22, 60, 10, Clock.Period.AM));
        assertThrows(IllegalArgumentException.class, () -> new Clock(20, 10, 61, Clock.Period.AM));


    }

    @Test
    void printHour24() {
        Clock c = new Clock(18, 45, 32);
        assertEquals("18:45:32", c.printHour24());

        c = new Clock(10, 30, 45, Clock.Period.PM);
        assertEquals("22:30:45", c.printHour24());

        c = new Clock(12, 0, 0, Clock.Period.AM);
        assertEquals("00:00:00", c.printHour24());

        //añadidos----------------------------------------------------
        c = new Clock(10, 10, 10, Clock.Period.AM);
        assertEquals(c.printHour24(), "10:10:10");
    }

    @Test
    void printHour12() {
        Clock c = new Clock(18, 45, 32);
        assertEquals("06:45:32 PM", c.printHour12());

        c = new Clock(10, 30, 45, Clock.Period.PM);
        assertEquals("10:30:45 PM", c.printHour12());

        c = new Clock(12, 0, 0, Clock.Period.AM);
        assertEquals("12:00:00 AM", c.printHour12());
    }

    @Test
    void testEquals() {
        Clock c1 = new Clock(17, 30, 30);
        Clock c2 = new Clock( 5, 30, 30, Clock.Period.PM);
        Clock c3 = new Clock( 5 ,30, 30, Clock.Period.AM);

        assertEquals(c2, c1);
        assertEquals(c1, c2);

        assertNotEquals(c3, c1);
        assertNotEquals(c3, c2);

        assertNotEquals(c1, null);
        assertNotEquals(new Object(), c1);

        //añadidos------------------------
        String a = "a";
        assertEquals(c1, c1);
        assertNotEquals(c1, a);
    }

    @Test
    void testHashCode() {
        Clock c1 = new Clock(17, 30, 30);
        Clock c2 = new Clock( 5, 30, 30, Clock.Period.PM);
        Clock c3 = new Clock( 5 ,30, 30, Clock.Period.AM);

        assertEquals(c2.hashCode(), c1.hashCode());
        assertTrue(c1.hashCode() != c3.hashCode());
    }
}