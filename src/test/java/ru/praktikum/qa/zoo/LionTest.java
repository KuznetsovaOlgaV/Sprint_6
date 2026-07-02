package ru.praktikum.qa.zoo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Predator predatorMock;

    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lionMale = new Lion("Самец", predatorMock);
        lionFemale = new Lion("Самка", predatorMock);
    }

    @Test
    public void doesHaveManeMale() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemale() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructorThrowsForInvalidSex() throws Exception {
        new Lion("Неизвестный", null);
    }

    @Test
    public void getFoodReturnsExpectedList() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expected);
        List<String> result = lionMale.getFood();
        assertEquals(expected, result);
    }

    @Test
    public void getFoodDelegatesToPredator() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные"));
        lionMale.getFood();
        verify(predatorMock).eatMeat();
    }

    @Test(expected = Exception.class)  // для исключения, чтобы 100% покрыть
    public void getFoodExceptionFromPredator() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        lionMale.getFood();
    }
}