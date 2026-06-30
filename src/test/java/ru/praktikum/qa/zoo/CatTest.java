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
    private Predator predatorMock;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(predatorMock);
    }

    @Test
    public void getSound_returnsМяу() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood_delegatesToPredator() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expected);

        List<String> result = cat.getFood();

        verify(predatorMock).eatMeat();
        assertEquals(expected, result);
    }


}