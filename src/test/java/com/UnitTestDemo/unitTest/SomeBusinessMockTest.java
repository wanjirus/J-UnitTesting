package com.UnitTestDemo.unitTest;

import com.UnitTestDemo.unitTest.business.SomeBusinessImpl;
import com.UnitTestDemo.unitTest.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();
    @Mock
    SomeDataService dataServiceMock = mock(SomeDataService.class);


    @BeforeEach
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    public void testCalculateSumUsingDataService_basic() {
        //dataServiceMock retrieveAllData new int[] {1,2,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertThat(business.calculateSumUsingDataService()).isEqualTo(6);
    }

    @Test
    public void testCalculateSumEmpty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{ });

//        business.setSomeDataService(new SomeDataServiceEmptyStub());
        assertThat(business.calculateSumUsingDataService()).isEqualTo(0);
    }
    @Test
    public void testCalculateSumOneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});

        //        business.setSomeDataService(new SomeDataServiceOneStub());
        int expectedResult = 5;
        assertThat(business.calculateSumUsingDataService()).isEqualTo(expectedResult);
    }
}