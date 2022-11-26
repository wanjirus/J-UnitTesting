package com.UnitTestDemo.unitTest.business;

import com.UnitTestDemo.unitTest.data.SomeDataServiceOne;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class SomeDataServiceStub implements SomeDataServiceOne{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataServiceOne{

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}
class SomeDataServiceOneStub implements SomeDataServiceOne{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1};
    }
}




public class SomeBusinessImplStubTest {

    @Test
    void testCalculateSumDataService_basic() {
        //Given
        SomeBusinessImpl someBusinessUnderTest = new SomeBusinessImpl();
        //when
        someBusinessUnderTest.setSomeDataServiceOne(new SomeDataServiceStub());

        int actual = someBusinessUnderTest.calculateSumUsingDataService();
        //then
        int expected = 6;
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testCalculateSumEmptyUsingStubs() {
        //given
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataServiceOne(new SomeDataServiceEmptyStub());
       //when
        int actualResult = business.calculateSumUsingDataService();
        //then
        int expectedResult = 0;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testCalculateSumOneValueUsingStubs() {
        SomeBusinessImpl underTest = new SomeBusinessImpl();
        underTest.setSomeDataServiceOne(new SomeDataServiceOneStub());
        int actual = underTest.calculateSumUsingDataService();
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
}