package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.CookieGram;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import com.zenoprogramming.com.cookiegram.dto.OrderRequest;
import com.zenoprogramming.com.cookiegram.dto.OrderRequestResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
      OrderRequestResponse requestResponse = CookieGram.instanceOfOrderManager().createOrder(orderRequest);
      model.addAttribute("response", requestResponse);
      model.addAttribute("message", requestResponse.getReturnMessageToUser());
      return requestResponse.getHtmlPage();
   }

   @RequestMapping("/viewtodaysbaking")
   public String viewTodaysBakingOrders (Model model)
   {
      List<CookieOrder> orders = CookieGram.instanceOfOrderManager().getTodaysBakingOrders();
      List<String> ordersAsStrings = new ArrayList<String>();
      model.addAttribute("ordersAsStrings", orders);
      return "todaysbakingorders.html";
   }

   @RequestMapping("/completeBake")
   public String completeBake (Model model, @ModelAttribute CookieOrder order)
   {

      System.out.println("Yay!!! " + order.getOrderNumber());
      return "/completeBake";
   }

}
