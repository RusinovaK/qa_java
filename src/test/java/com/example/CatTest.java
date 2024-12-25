package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void shouldGetSound() {
        Cat cat = new Cat();
        String actual = cat.getSound();
        String expected = "Мяу";

        Assert.assertEquals(expected, actual);
    }

    @Mock
    Feline stabFeline;
    @Test
    public void shouldGetFood() throws Exception {
        Cat cat = new Cat(stabFeline);
        Mockito.when(stabFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = stabFeline.eatMeat();
        List<String> actual = cat.getFood();

        Assert.assertEquals(expected, actual);
    }
}
