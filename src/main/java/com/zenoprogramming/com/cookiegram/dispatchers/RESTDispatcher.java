package com.zenoprogramming.com.cookiegram.dispatchers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
@RestController
public class RESTDispatcher
{

   @RequestMapping("/easteregg")
   public String helloWorld ()
   {
      return "Yay!!! Hello CookieGram!";
   }

}
