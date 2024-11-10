package com.mockito.exercise.sharing;

import com.mockito.exercise.sharing.assignment.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Mock
    private Calculator mockCalculator;

    @ExtendWith(MockitoExtension.class)
    @Test
    public void addTest(){
        //arrange


        when(mockCalculator.add(2,3)).thenReturn(5);

        int result = mockCalculator.add(2,3);

        assertEquals(5,result);
        verify(mockCalculator,times(1)).add(2,3);


    }



}
