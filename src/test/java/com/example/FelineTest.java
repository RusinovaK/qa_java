package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Animal stabAnimal;
    @Test
    public void getFoodWhenKindPredator() throws Exception {
        Feline feline = new Feline(stabAnimal);
        Mockito.when(stabAnimal.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        stabAnimal.getFood("Хищник");
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyWhenFamilyFeline() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";

        Assert.assertEquals(expected, actual);
    }

    @Spy
    private Feline feline;
    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParamWhenOneKitten() {
        Feline feline = new Feline();
        int actual = feline.getKittens(1);
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

}
