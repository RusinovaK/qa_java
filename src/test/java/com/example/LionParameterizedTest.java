package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean expected;

    public LionParameterizedTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParam() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void checkIfSexParamThenHasManeParam() throws Exception {
            Lion lion = new Lion(sex);
            boolean actual = lion.hasMane;
            Assert.assertEquals(expected, actual);
    }
}
