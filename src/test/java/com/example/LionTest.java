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

    @Test
    public void checkExceptionWhenInvalidParam() {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion("Не определено", feline);
            Assert.fail("Exception not thrown");
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Mock
    Feline stabFeline;
    @Test
    public void getKittensWhenOneKitten() throws Exception {
        Lion lion = new Lion("Самец", stabFeline);
        Mockito.when(stabFeline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDoesHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFood() throws Exception {
        Lion lion = new Lion("Самец", stabFeline);
        Mockito.when(stabFeline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        stabFeline.getFood("Хищник");
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, actual);
    }
}
