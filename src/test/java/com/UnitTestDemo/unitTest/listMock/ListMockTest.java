package com.UnitTestDemo.unitTest.listMock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import  static org.junit.Assert.*;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);

    @Test
    //basic size test
    public void size_basic(){

        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());

    }
    @Test
    //return multiple values
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10).thenReturn(6);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
        assertEquals(6, mock.size());

    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("in 3 hours");
        assertEquals("in 3 hours", mock.get(0));
        assertEquals(null, mock.get(1));

    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("in 3 hours");
        assertEquals("in 3 hours", mock.get(1));
        assertEquals("in 3 hours", mock.get(1));

    }
    @Test
    public void verificationBasics(){
        String value = mock.get(0);
        String value2 = mock.get(1);
        verify(mock).get(0);
        //check if any parameter is usable(int) is called once, by default requires one call
//        verify(mock).get(anyInt());


        //verify method is called  once

//        verify(mock, times(1)).get(anyInt());

        //verify a method is called a number of times
//        verify(mock, times(2)).get(anyInt());


//        verify a method is called atleast a number of times
        verify(mock, atLeast(2)).get(anyInt());

        //        verify a method is called atmost a number of times
        verify(mock, atLeast(2)).get(anyInt());
        verify(mock,never()).get(2);


    }
//capturing a parameter of an argument passed to a method
    @Test
    public void argumentCapturing(){
        //assuming system under test
        mock.add("someString");
        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("someString", captor.getValue());
    }
}
