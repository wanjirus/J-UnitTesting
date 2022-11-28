package com.UnitTestDemo.unitTest.controller;

import com.UnitTestDemo.unitTest.business.ItemBusinessService;
import com.UnitTestDemo.unitTest.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//annotations required for testing the helloWorldController only
@RunWith(SpringRunner.class) //LAUNCH A SPRING UNIT TEST
@WebMvcTest(ItemController.class)   //TEST ONLY THE HelloWorldController.
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        //call "/hello-word"
        //verify  "hello world" is returned

        //build a request using RequestBuilder and define
        // the type and the url of the request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        //use MockMvc to execute requests.and use the
        // MvcRessult to get the return of the request call
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))  //

                .andReturn();

        //verify if returned value is correct

        //NOT NECESSARY IF MATCHER RESPONSE IS DEFINED AND RESPONSE IS LESS COMPLICATED
        assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", result.getResponse().getContentAsString());
//        JSONAssert.assertEquals(expected, actual, false);

    }
    @Test
    public void itemFromBusinessService_basic() throws Exception {
        //call "/hello-word"
        //verify  "hello world" is returned

        //build a request using RequestBuilder and define
        // the type and the url of the request


        //mocking the business service

     when(businessService.retrieveHardcodedItem()).thenReturn(new Item(3,"ball",10,100));


        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        //use MockMvc to execute requests.and use the
        // MvcRessult to get the return of the request call
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{id: 3,name:ball,price:10,quantity:100}"))  //
                .andReturn();

    }
}
