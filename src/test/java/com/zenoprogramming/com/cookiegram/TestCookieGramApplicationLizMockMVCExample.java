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
public class TestCookieGramApplicationLizMockMVCExample {
@Autowired
private MockMvc mockMvc;

     /**
      * A basic test to make sure the page loads
      * Tests that ordercookieform will load
      */
@Test
public void testOrderCookieUseCase () throws Exception
   {
      mockMvc.perform(MockMvcRequestBuilders.get("/ordercookieform")).andExpect(status().isOk());
   }

}