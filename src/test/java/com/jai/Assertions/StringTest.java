package com.jai.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    @Test
    void stringContainsWord() {
        String sentence = "JUnit makes Java testing easy";
        assertTrue(sentence.contains("testing"), "Sentence should contain the word 'testing'");
    }

    @Test
    void stringDoesNotContainWord() {
        String sentence = "JUnit makes Java testing easy";
        assertFalse(sentence.contains("difficult"), "Sentence should not contain the word 'difficult'");
    }
}
