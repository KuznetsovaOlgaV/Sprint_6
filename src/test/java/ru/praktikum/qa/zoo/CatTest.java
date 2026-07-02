package ru.praktikum.qa.zoo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsExpectedList() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expected);

        List<String> result = cat.getFood();

        assertEquals(expected, result);
    }

    @Test
    public void getFoodDelegatesToFeline() throws Exception {
        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные"));

        cat.getFood();

        verify(felineMock).eatMeat();
    }

    @Test(expected = Exception.class) // для исключения, чтобы 100% покрыть
    public void getFoodExceptionFromFeline() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        cat.getFood();
    }
}