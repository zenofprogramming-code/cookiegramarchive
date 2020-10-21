package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.dto.OrderRequest;
import com.zenoprogramming.com.cookiegram.dto.OrderRequestResponse;
import com.zenoprogramming.com.cookiegram.usecasemanagers.OrderManager;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
@Controller
public class RESTDispatcher
{

   @RequestMapping("/easteregg")
   public String helloWorld ()
   {
      return "Yay!!! Hello CookieGram!";
   }

   @RequestMapping("/ordercookieform")
   public String orderCookieForm (Model model)
   {
      model.addAttribute(new OrderRequest("", "", "", "", "", "", "", "", LocalDate.now()));
      model.addAttribute("message", "Hurray!  Our chefs are very exited and can't wait to start baking!  Please fill out this form:");
      return "ordercookieform.html";
   }

   @RequestMapping("/orderrequest")
   public String orderCookie (Model model, @ModelAttribute OrderRequest orderRequest)
   {
      OrderRequestResponse requestResponse = new OrderManager().createOrder(orderRequest);
      model.addAttribute("response", requestResponse);
      model.addAttribute("message", requestResponse.getReturnMessageToUser());
      return requestResponse.getHtmlPage();

   }



}
