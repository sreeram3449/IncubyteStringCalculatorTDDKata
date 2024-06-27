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

    /**
     * Returns sum of numbers if passed a String containing two numbers seperated by coma
     */
    @Test
    public void shouldReturnSumOfNumbersOnTwoNumberString(){
        assertEquals(3,StringCalculator.add("1,2"));
    }

    //TODO test should return sum of all N numbers if passed a string containing N numbers
}
