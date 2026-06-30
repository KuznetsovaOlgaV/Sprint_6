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
    public void doesHaveMane_male() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void doesHaveMane_female() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructor_throwsForInvalidSex() throws Exception {
        new Lion("Неизвестный", null);
    }

    @Test
    public void getFood_delegatesToPredator() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expected);

        List<String> result = lionMale.getFood();

        verify(predatorMock).eatMeat();
        assertEquals(expected, result);
    }
}