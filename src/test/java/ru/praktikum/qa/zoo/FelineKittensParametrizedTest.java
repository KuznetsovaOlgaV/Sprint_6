package ru.praktikum.qa.zoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensParametrizedTest {

    private final int input;
    private final int expected;

    public FelineKittensParametrizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() { // котят считаем, добавила если порции не вариант
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {-1, -1},
                {7, 7},
                {1000, 1000}
        });
    }

    @Test
    public void getKittensReturnsGivenCount() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}