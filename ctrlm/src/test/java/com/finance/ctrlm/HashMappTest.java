package com.finance.ctrlm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMappTest {
    @Test
    public void testHashMapp(){
        HashMapp<String,String> myHash = new HashMapp<>();
        myHash.Put("User1", "Katherine");
        myHash.Put("User2", "Andrea");
        myHash.Put("User3", "No Name");

        assertNotNull(myHash);
        assertEquals(3,myHash.size());
        assertEquals("Katherine", myHash.Get("User1"));

    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }
}