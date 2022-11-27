package com.UnitTestDemo.unitTest.business;


import com.UnitTestDemo.unitTest.data.SomeDataServiceOne;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessImplMockTest {

    @Test
    void testCalculateSumDataService_basic() {
        //Given
        SomeBusinessImpl someBusinessUnderTest = new SomeBusinessImpl();
        SomeDataServiceOne someDatamock = mock(SomeDataServiceOne.class);
        //when
        when(someDatamock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        someBusinessUnderTest.setSomeDataServiceOne(someDatamock);

        int actual =  someBusinessUnderTest.calculateSumUsingDataService();
//       then
       int expected = 6;
        assertThat(actual).isEqualTo(expected);
//        someBusinessUnderTest.setSomeDataServiceOne(new SomeDataServiceStub());
//
//        int actual = someBusinessUnderTest.calculateSumUsingDataService();
//        //then
//        int expected = 6;
//        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testCalculateSumEmptyUsingMocks() {
        //given
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataServiceOne someDataMock = mock(SomeDataServiceOne.class);
        when(someDataMock.retrieveAllData()).thenReturn(new int[] { });
        business.setSomeDataServiceOne(someDataMock);
        int actual =  business.calculateSumUsingDataService();
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCalculateSumOneValueUsingStubs() {
        SomeBusinessImpl underTest = new SomeBusinessImpl();
        SomeDataServiceOne someDataMock = mock(SomeDataServiceOne.class);

        when(someDataMock.retrieveAllData()).thenReturn(new int[] {6});
        underTest.setSomeDataServiceOne(someDataMock);

        int actual = underTest.calculateSumUsingDataService();
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}
