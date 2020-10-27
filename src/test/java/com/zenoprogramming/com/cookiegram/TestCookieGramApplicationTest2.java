package com.zenoprogramming.com.cookiegram;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCookieGramApplicationTest2 {
     @Autowired
private MockMvc mockMvc;

     /**
      * A basic test to make sure the page loads
      */
@Test
public void testOrderCookieUseCase () throws Exception
   {
      mockMvc.perform(MockMvcRequestBuilders.get("/ordercookieform").accept(MediaType.ALL)).andExpect(status().isOk()).andReturn();
   }



}