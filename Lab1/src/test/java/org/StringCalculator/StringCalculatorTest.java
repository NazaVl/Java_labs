package org.StringCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {
    @Test
    void shouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void shouldReturnSameNumberForNumberOne() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void shouldReturnSumOfOneAndTwo() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2");
        assertEquals(3, result);
    }

    @Test
    void shouldReturnSumOfThreeArguments() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3");
        assertEquals(6, result);
    }
}