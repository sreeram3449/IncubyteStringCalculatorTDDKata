package org.incubyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    /**
     * Returns 0 if passed an Empty String
     */
    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }

    /**
     * Returns number if passed a String containing Single number
     */
    @Test
    public void shouldReturnNumberOnSingleNumberString(){
        assertEquals(1,StringCalculator.add("1"));
    }
}
