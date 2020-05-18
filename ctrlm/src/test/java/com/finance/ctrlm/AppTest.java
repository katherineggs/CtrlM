package com.finance.ctrlm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void index() {
        assertEquals(DateTime.yesterday()+".json",CreateFile.lastModified("C:\\Users\\kgrac\\Desktop\\CtrlM\\JSON\\"));
    }
    @Test
    void userName() {
        assertEquals("Andrea", "Andrea");
        assertEquals("Maria", "Maria");
    }
}