package com.UnitTestDemo.unitTest.business;

import com.UnitTestDemo.unitTest.data.SomeDataService;
import com.UnitTestDemo.unitTest.data.SomeDataServiceOne;

public class SomeBusinessImpl {
    SomeDataService someDataService;
    private SomeDataServiceOne someDataServiceOne;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public void setSomeDataServiceOne(SomeDataServiceOne someDataServiceOne) {
        this.someDataServiceOne = someDataServiceOne;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;

    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataServiceOne.retrieveAllData();
        for(int value:data){
            sum+=value;
        }
        //assuming the method doesnt return sum;
        //someDataService.storeSum(sum);
        return sum;
    }
 }
