package com.UnitTestDemo.unitTest.spying;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class IntroductionToSpyingTest {
    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        arrayListMock.add("test1");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());


    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test1"); //add a valuee to array
        System.out.println(arrayListSpy.get(0));// test1
        System.out.println(arrayListSpy.size());//1
        arrayListSpy.add("test1");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size());//3

        //take control force the size to be 5 and the original code is lost
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5

        //any more addition doesnt affect the size
        arrayListSpy.add("test1");
        System.out.println(arrayListSpy.size());//5

        verify(arrayListSpy, atLeast(1)).add("test1");


    }
}
