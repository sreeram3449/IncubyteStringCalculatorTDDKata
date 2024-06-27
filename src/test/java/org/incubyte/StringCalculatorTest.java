package org.incubyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }

    //TODO test for Single number in string should return same string
}
