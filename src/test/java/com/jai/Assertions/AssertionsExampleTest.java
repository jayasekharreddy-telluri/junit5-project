package com.jai.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsExampleTest {

    @Test
    void isPositiveNumber() {
        int number = 10;
        assertTrue(number > 0, "Number should be positive");
    }

    @Test
    void isNotNegativeNumber() {
        int number = 10;
        assertFalse(number < 0, "Number should not be negative");
    }
}
