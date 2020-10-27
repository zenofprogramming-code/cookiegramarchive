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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

   @GetMapping("/")
   public String landingPage ()
   {
      return "landingpage";
   }

   @RequestMapping("/ordercookie")
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

   @RequestMapping("/viewnextsevendaysbaking")
   public String viewNextSevenDaysBakingOrders (Model model)
   {
      List<CookieOrder> orders = CookieGram.instanceOfOrderManager().getnextSevenDaysBakingOrders();
//      List<String> ordersAsStrings = new ArrayList<String>();
      List<String> status = new ArrayList<String>();
      status.add("Not Paid");
      status.add("Pending");
      status.add("Baked");
      status.add("Delivered");
      model.addAttribute("status", status);
      model.addAttribute("orders", orders);
      return "bakingorders.html";
   }

//   @RequestMapping("/completeBake")
//   public String completeBake (Model model, @ModelAttribute CookieOrder order)
//   {
//      System.out.println("Yay!!! " + order.toString());
//      return "redirect:/viewtodaysbaking";
//   }


   @GetMapping(value = "/completeBake/{orderId}")
   public String getTestData (@PathVariable int orderId)
   {
      System.out.println("Yay!");
      System.out.println(orderId);
      return "redirect:/viewtodaysbaking";
   }

}
