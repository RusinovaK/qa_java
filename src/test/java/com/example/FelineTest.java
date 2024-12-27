package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline spyFeline;

    @Test
    public void eatMeatNoParamInvokeGetFoodWithParamPredator() throws Exception {
        spyFeline.eatMeat();
        Mockito.verify(spyFeline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyWhenFamilyFeline() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        spyFeline.getKittens();
        Mockito.verify(spyFeline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParamWhenOneKitten() {
        Feline feline = new Feline();
        int actual = feline.getKittens(1);
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

}
