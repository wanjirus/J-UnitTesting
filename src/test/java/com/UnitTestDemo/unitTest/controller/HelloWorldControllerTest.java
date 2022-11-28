package com.UnitTestDemo.unitTest.controller;

import org.junit.experimental.results.ResultMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//annotations required for testing the helloWorldController only
@RunWith(SpringRunner.class) //LAUNCH A SPRING UNIT TEST
@WebMvcTest(HelloWorldController.class)   //TEST ONLY THE HelloWorldController.
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testHelloWorld() throws Exception {
        //call "/hello-word"
        //verify  "hello world" is returned

        //build a request using RequestBuilder and define
        // the type and the url of the request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        //use MockMvc to execute requests.and use the
        // MvcRessult to get the return of the request call
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().string("hello world"))  //

                .andReturn();

        //verify if returned value is correct

        //NOT NECESSARY IF MATCHER RESPONSE IS DEFINED AND RESPONSE IS LESS COMPLICATED
        assertEquals("hello world", result.getResponse().getContentAsString());


    }
}
