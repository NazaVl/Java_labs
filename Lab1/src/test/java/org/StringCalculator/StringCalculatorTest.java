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

    @Test
    void CatchTwoDelimiterInRow() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1,\n2,3"));
    }

    @Test
    void TryCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1001;2;3");
        assertEquals(5, result);
    }

    @Test
    void CatchCustomInvalidDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2;3");
        assertThrows(IllegalArgumentException.class, () -> calculator.add("//if\n1if2,3"));
    }

    @Test
    void CatchNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(NumberFormatException.class, () -> calculator.add("-1,2"));
    }

    @Test
    void IgnoreNumbersOverThousand() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1000,999,1001");
        assertEquals(1999, result);
    }

    @Test
    void TryLongCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[***]\n10***2***3");
        assertEquals(15, result);
    }

    @Test
    void CatchInvalidLongDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.add("//[]]\n10]2]3"));
    }

    @Test
    void CatchInvalidLongDelimiterSecondTime() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.add("//[]f\n10f2f3"));
    }

    @Test
    void TryMoreThanOneDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[*][%]\n10*2%3");
        assertEquals(15, result);
    }
}