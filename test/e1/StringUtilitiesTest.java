package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilitiesTest {

    @Test
    void pruebaIsValidMix() {
        Assertions.assertFalse(StringUtilities.isValidMix("aaa", "bbb", "ccccccccc"));
        assertFalse(StringUtilities.isValidMix("abc", "def", "abxded"));
        assertTrue(StringUtilities.isValidMix("abc", "def", "abcdef"));
    }

    @Test
    void pruebaGenerateRandomValidMix() {
        assertTrue(StringUtilities.isValidMix("abc", "def", StringUtilities.generateRandomValidMix("abc", "def")));
        assertFalse(StringUtilities.isValidMix("asd", "fgh", StringUtilities.generateRandomValidMix("abc", "def")));

    }
}