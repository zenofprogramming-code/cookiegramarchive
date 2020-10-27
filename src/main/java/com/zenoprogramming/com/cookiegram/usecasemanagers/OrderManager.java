package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.CookieGram;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import com.zenoprogramming.com.cookiegram.domainobjects.Settings;
import com.zenoprogramming.com.cookiegram.dto.OrderRequest;
import com.zenoprogramming.com.cookiegram.dto.OrderRequestResponse;
import com.zenoprogramming.com.cookiegram.dto.PaymentResponse;
import java.time.LocalDate;
import java.util.List;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

public class OrderManager
{
   private final int MINIMUMLEADTIME = 2;
   
   public OrderRequestResponse createOrder (OrderRequest orderRequest)
   {
      if (this.orderDateInPast(orderRequest)) {
         String userMessage = "Sorry, your order date is in the past.  Please correct and resubmit your order";
         return new OrderRequestResponse(false, userMessage, "ordercookieForm.html");
      }
      if (this.orderDateIsTooSoonToToday(orderRequest)) {
         String userMessage = "Sorry, your order date must be at least two days from now.  Please correct and resubmit your order!";
         return new OrderRequestResponse(false, userMessage, "ordercookieForm.html");
      }
      
      if (this.atMaxOrdersForThisDate(orderRequest)) {
         String userMessage = "Sorry, we are at our maximum number of orders for that date.  Is there another date that might work?";
         return new OrderRequestResponse(false, userMessage, "ordercookieForm.html");
      }
      
      if (!CookieGram.instanceOfShippingManager().verifyValidShippingAddress(orderRequest)) {
         String userMessage = "Sorry, we can't ship to that address ";
         return new OrderRequestResponse(false, userMessage, "ordercookieForm.html");
      }
      
      CookieOrder cookieOrder = this.buildCookieOrder(orderRequest);
      CookieGram.instanceOfOrderPersistanceManager().saveOrderToRepository(cookieOrder);
      
      String userMessage = "Thank you for your order!  Our chefs are busily tying their aprons and setting their chef hats firmly in place to bake your order to be delivered on " + orderRequest.getDeliveryDate() + "!!!";
      return new OrderRequestResponse(true, userMessage, "paymentform.html");
      
   }
   
   public double getShippingCosts (OrderRequest orderRequest)
   {
      ShippingManager shipping = CookieGram.instanceOfShippingManager();
      return shipping.getShippingCosts(orderRequest);
   }
   
   public CookieOrder buildCookieOrder (OrderRequest orderRequest)
   {
      
      CookieOrder order = new CookieOrder();
      order.setOrderNumber(CookieGram.instanceOfOrderPersistanceManager().getNextOrderNumber());
      order.setCustomerName(orderRequest.getCustomerName());
      order.setRecipientName(orderRequest.getRecipientName());
      order.setRecipientStreetAddress(orderRequest.getRecipientStreetAddress());
      order.setRecipientCity(orderRequest.getRecipientCity());
      order.setRecipientCode(orderRequest.getRecipientCode());
      order.setRecipientCountry(orderRequest.getRecipientCountry());
      order.setShipDate(orderRequest.getDeliveryDate());
      order.setCookieMessage(orderRequest.getCookieMessage());
      Settings settings = CookieGram.instanceOfSettingsPersistanceManager().getSettings();
      order.setCost(settings.getStandardCookieCost());
      order.setTaxes(settings.getStandardTax());
      order.setShippingCosts(getShippingCosts(orderRequest));
      return order;
   }
   
   public PaymentResponse payForOrder (CookieOrder order)
   {
      PaymentManager paymentManager = CookieGram.instanceOfPaymentManager();
      PaymentResponse paymentResponse = paymentManager.makePayment(order);
      return paymentResponse;
   }
   
   public boolean orderDateInPast (OrderRequest orderRequest)
   {
      return (orderRequest.getDeliveryDate().isBefore(LocalDate.now()));
   }
   
   public boolean orderDateIsTooSoonToToday (OrderRequest orderRequest)
   {
      return (orderRequest.getDeliveryDate().isBefore(LocalDate.now().plusDays(MINIMUMLEADTIME)));
   }
   
   public boolean atMaxOrdersForThisDate (OrderRequest orderRequest)
   {
      Settings settings = CookieGram.instanceOfSettingsPersistanceManager().getSettings();
      int maxNumberBakes = settings.getNumBakesPerDayDefault();
      if (settings.getSpecialDates().containsKey(orderRequest.getDeliveryDate())) {
         maxNumberBakes = settings.getSpecialDates().get(orderRequest.getDeliveryDate());
      }
      OrderPersistanceManager orderPersistanceManager = CookieGram.instanceOfOrderPersistanceManager();
      int numOrdersAlreadyOnDate = orderPersistanceManager.getDaysBakingOrders(orderRequest.getDeliveryDate().minusDays(2)).size();
      return (numOrdersAlreadyOnDate >= maxNumberBakes);
   }
   
   public List<CookieOrder> getTodaysBakingOrders ()
   {
      OrderPersistanceManager orderPersistanceManager = CookieGram.instanceOfOrderPersistanceManager();
      return orderPersistanceManager.getDaysBakingOrders(LocalDate.now());
   }
   
   public List<CookieOrder> getnextSevenDaysBakingOrders ()
   {
      OrderPersistanceManager orderPersistanceManager = CookieGram.instanceOfOrderPersistanceManager();
      return orderPersistanceManager.getNextSevenDaysBakingOrders(LocalDate.now());
   }
   
}
