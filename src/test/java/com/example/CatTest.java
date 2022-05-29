package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class CatTest extends TestCase {
@Mock
private  Feline feline;
private  Cat cat;
@Before
    public void init(){
        cat = new Cat(feline);
    }
@Test
    public void testGetSound() {
        assertEquals("Мяу",  cat.getSound());
    }
@Test
    public void testGetFood() throws Exception {
    List<String> meat = List.of("Животные", "Птицы", "Рыба");
    when(feline.eatMeat()).thenReturn(meat);
    assertEquals(meat, cat.getFood());
    }
}