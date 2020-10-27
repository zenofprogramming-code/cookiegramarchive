package com.zenoprogramming.com.cookiegram;

import com.zenoprogramming.com.cookiegram.dispatchers.RESTDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class CookieGramApplicationTests
{
   @Autowired
   private MockMvc mockMvc;
   private RESTDispatcher restDispatcher;

   @Before
   public void setup ()
   {
      restDispatcher = new RESTDispatcher();
      mockMvc = MockMvcBuilders.standaloneSetup(restDispatcher).build();
   }

   @Test
   public void testOrderRequestUseCase () throws Exception
   {
      this.mockMvc.perform(get("/"))
          .andExpect(status().isOk());


   }


}
