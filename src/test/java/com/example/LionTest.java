package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline stabFeline;
    @Test
    public void getKittensWhenOneKitten() {
        Lion lion = new Lion(stabFeline);
        Mockito.when(stabFeline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDoesHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actual = lion.doesHaveMane();
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Mock
    Animal stabAnimal;

    @Test
    public void shouldGetFood() throws Exception {
        Lion lion = new Lion(stabAnimal);
        Mockito.when(stabAnimal.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        stabAnimal.getFood("Хищник");
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, actual);
    }
}
