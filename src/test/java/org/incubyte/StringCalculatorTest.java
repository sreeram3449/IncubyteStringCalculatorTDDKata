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
     * Returns sum of numbers if passed a String containing two numbers separated by comma
     */
    @Test
    public void shouldReturnSumOfNumbersOnTwoNumberString(){
        assertEquals(3,StringCalculator.add("1,2"));
    }

    /**
     *     Returns sum of all N numbers if passed a string containing N numbers separated by comma
     */
    @Test
    public void shouldReturnSumOfNNumbersOnNNumberedString(){
        assertEquals(6,StringCalculator.add("1,2,3"));
    }

    /**
     *   Should allow \n as delimiter along with comma
     */
    @Test
    public void shouldHandleNewLineAsDelimiterAlongWithComma(){
        assertEquals(6,StringCalculator.add("1\n2,3"));
    }

    /**
     * Should handle custom delimiter passed in between // and \n at the beginning of the String
     */
    @Test
    public void shouldHandleCustomDelimiter(){
        assertEquals(3,StringCalculator.add("//;\n1;2"));
    }

    /**
     *    Should handle any regex character as custom delimiter in place of ";"
     */
    @Test
    public void shouldHandleAnyRegexCharAsCustomDelimiter(){
        assertEquals(3,StringCalculator.add("//.\n1.2"));
    }

    /**
     *     should throw Exception if passed a String with negative numbers
     */
    @Test
    public void shouldThrowExceptionOnNegativeNumberInString(){
        Exception e = assertThrows(RuntimeException.class,() -> StringCalculator.add("//.\n1.-4.3"));
        assertEquals("Negative numbers not allowed -4",e.getMessage());
    }

    //TODO should throw Exception with list of numbers if passed a String with multiple negative numbers
}
