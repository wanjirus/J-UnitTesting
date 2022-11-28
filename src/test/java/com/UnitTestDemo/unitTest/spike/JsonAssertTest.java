package com.UnitTestDemo.unitTest.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse = "{id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces()throws JSONException {
       String expectedResponse = "{id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

       //JSONAssert.assertEquals method provides field strict for strict verification of values
        //strict:true for strict checking and false for checking some values
        JSONAssert.assertEquals(expectedResponse, actualResponse,true);
    }

    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces()throws JSONException {
        String expectedResponse = "{id\":1,\"name\":\"Ball\",\"price\":10}";

        //JSONAssert.assertEquals method provides field strict for strict verification of values
        //strict:true for strict checking and false for checking some values
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    @Test
    public void jsonAssert_WithoutEscapeCharacters()throws JSONException {
        String expectedResponse = "{id\":1,name:Ball,price:10,quantity:100}";

        //JSONAssert.assertEquals method provides field strict for strict verification of values
        //strict:true for strict checking and false for checking some values
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
