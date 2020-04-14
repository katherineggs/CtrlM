package com.finance.ctrlm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void index() {
        assertEquals("food", "food");
        assertEquals("coffee", "coffee");
        assertEquals("super", "super");
    }

    @Test
    void add() {
        assertEquals("food", "food");
        assertEquals(56, 56);
    }
}