package com.jai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator  calculator = new Calculator();

        int actualResult = calculator.add(1,3);

        assertEquals(4,actualResult);
    }
}