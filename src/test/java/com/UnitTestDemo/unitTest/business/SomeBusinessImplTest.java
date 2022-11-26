package com.UnitTestDemo.unitTest.business;

import com.UnitTestDemo.unitTest.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SomeBusinessImplTest {

    @Test
    void testCalculateSum() {
        //Given
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        //when

        int actual = someBusiness.calculateSum(new int[]{1, 2, 3});
        //then
        int expected = 6;
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void testCalculateSumEmpty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testCalculateSumOneValue() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actual = someBusiness.calculateSum(new int[]{1});
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}