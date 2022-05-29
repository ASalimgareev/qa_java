package com.example;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private static Feline feline;
    private final static Random random = new Random();

    @BeforeClass
    public static void init() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensParameterized() {
        int kittensCount = random.nextInt();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
