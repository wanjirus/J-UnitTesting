package com.UnitTestDemo.unitTest;

import com.UnitTestDemo.unitTest.business.SomeBusinessImpl;
import com.UnitTestDemo.unitTest.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SomeDataServiceStub implements SomeDataService{
SomeDataService someDataService;
    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}
class SomeDataServiceOneStub implements SomeDataService{
    SomeDataService someDataService;
    @Override
    public int[] retrieveAllData() {
        return new int[] { 5 };
    }
}
class SomeDataServiceEmptyStub implements SomeDataService{
    SomeDataService someDataService;
    @Override
    public int[] retrieveAllData() {
        return new int[] { };
    }
}

public class SomeBusinessStubTest {

    @Test
    void testCalculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testCalculateSumEmpty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    void testCalculateSumOneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}