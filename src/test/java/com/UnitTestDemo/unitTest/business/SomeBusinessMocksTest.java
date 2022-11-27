package com.UnitTestDemo.unitTest.business;

import com.UnitTestDemo.unitTest.data.SomeDataServiceOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class
SomeBusinessMocksTest{
@InjectMocks
    SomeBusinessImpl business;
@Mock
SomeDataServiceOne someDataMock;

//    @BeforeEach
//    public void before(){
//        business.setSomeDataServiceOne(someDataMock);
//    }

    @Test
      public  void testCalculateSumDataService_basic() {
            //Given
         //when
            when(someDataMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertThat(business.calculateSumUsingDataService()).isEqualTo(6);
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
            when(someDataMock.retrieveAllData()).thenReturn(new int[]{});
            assertThat(business.calculateSumUsingDataService()).isEqualTo(0);
        }

        @Test
      public  void testCalculateSumOneValueUsingStubs() {
            when(someDataMock.retrieveAllData()).thenReturn(new int[]{6});
            assertThat(business.calculateSumUsingDataService()).isEqualTo(6);
        }
    }


