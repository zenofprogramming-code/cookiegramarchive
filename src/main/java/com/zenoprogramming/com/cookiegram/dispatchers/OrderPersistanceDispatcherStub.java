package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import com.zenoprogramming.com.cookiegram.usecasemanagers.OrderPersistanceManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class OrderPersistanceDispatcherStub implements OrderPersistanceManager
{

   private List<CookieOrder> orders = new ArrayList<CookieOrder>();
   private static int nextOrderNumber;

   public OrderPersistanceDispatcherStub ()
   {
      System.out.println("In constructor of OrderPersistaceDispatcherStub - generating test orders");
      saveOrderToRepository(new CookieOrder(1, "Liz", "Liz@PRE.com", "Rich", "123 Happy Street",
                                            "NOTL", "LZ41E4", "Canada", "Sorry for being so mean and making fun of your colours!", LocalDate.now(), 14.99, 4.99, 5.99, 55.55));
      saveOrderToRepository(new CookieOrder(2, "Rich", "Rich@PRE.com", "Liz", "123 Mean Street", "Virgil", "LZ41E4", "Canada",
                                            "I'm really glad you're teaching Capsone", LocalDate.now(), 14.99, 4.99, 5.99, 55.55));
      saveOrderToRepository(new CookieOrder(3, "Rich & Liz", "Rich@PRE.com", "Mark", "123 BigBoss Street", "Welland", "LZ41E4", "Canada",
                                            "We want a raise", LocalDate.now(), 14.99, 4.99, 5.99, 55.55));
   }


   @Override
   public boolean saveOrderToRepository (CookieOrder cookieOrder)
   {
      orders.add(cookieOrder);
      return true;
   }

   @Override
   public CookieOrder getOrderByOrderNumber (int orderNumber)
   {
      for (CookieOrder order : orders) {
         if (order.getOrderNumber() == orderNumber) {
            return order;
         }
      }
      return null;
   }

   @Override
   public List<CookieOrder> getAllOrders ()
   {
      return orders;
   }


   @Override
   public int getNextOrderNumber ()
   {
      nextOrderNumber++;
      return nextOrderNumber;
   }

   @Override
   public List<CookieOrder> getDaysBakingOrders (LocalDate date)
   {
      List<CookieOrder> todaysOrders = new ArrayList<CookieOrder>();
      for (CookieOrder order : orders) {
         if (date.equals(order.getShipDate())) {
            todaysOrders.add(order);
         }
      }
      return todaysOrders;
   }

   @Override
   public List<CookieOrder> getDaysShippingOrders (LocalDate date)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public List<CookieOrder> getNextSevenDaysBakingOrders (LocalDate date)
   {
      List<CookieOrder> todaysOrders = new ArrayList<CookieOrder>();
      for (CookieOrder order : orders) {
         if (order.getShipDate().isAfter(date) && order.getShipDate().isBefore(date.plusDays(7))) {
            todaysOrders.add(order);
         }
         if (order.getShipDate().equals(date)) {
            todaysOrders.add(order);
         }
      }
      return todaysOrders;
   }


}
