package com.zenoprogramming.com.cookiegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CookieGramApplicationTests
{
   @Autowired
   private MockMvc mockMvc;

//   @Test
//   void contextLoads ()
//   {
//   }

//   @Test
//   public void testOrderRequestUseCase ()
//   {
//      this.mockMvc.perform(get("/orderrequest"))
//          .andExpect(status().isOk());
//
//
//   }


}
