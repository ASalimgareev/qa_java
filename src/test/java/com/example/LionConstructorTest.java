package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class LionConstructorTest {
    @Test
    public void testConstructor() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("АУФ"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
