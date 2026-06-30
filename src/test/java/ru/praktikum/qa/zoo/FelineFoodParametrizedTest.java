package ru.praktikum.qa.zoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineFoodParametrizedTest {

    private final int hours;
    private final double expected;

    public FelineFoodParametrizedTest(int hours, double expected) {
        this.hours = hours;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0.0},
                {1, 2.5},
                {2, 5.0},
                {4, 10.0},
                {10, 25.0},
                {-1, -2.5},
                {1000, 2500.0}
        });
    }

    @Test
    public void getFood_parametrized() throws Exception {
        Feline feline = new Feline();
        assertEquals(expected, feline.getFood(hours), 0.001); // 0,001 для точности
    }
}
