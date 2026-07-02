package com.cognizant.deepskilling.junitspringboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(2, 3);
        assertEquals(5, result);
    }

    @ParameterizedTest
    @CsvSource({"2, 4, 6", "-4, 4, 0", "1, 1, 2", "0, 0, 0"})

    public void testAddParameterized(int a, int b, int expected) {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(a, b);
        assertEquals(expected, result);
    }
}