package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest extends TestCase {
    private static Random random = new Random();
    @Mock
    Feline feline;
    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex);
        lion.feline = feline;
    }

    @Test
    public void testGetKittens() {
        int count = random.nextInt();
        Mockito.when(feline.getKittens()).thenReturn(count);
        assertEquals(count, lion.getKittens());

    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(any())).thenReturn(food);
        assertEquals(food, lion.getFood());
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }
}