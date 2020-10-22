package com.zenoprogramming.com.cookiegram;

import com.zenoprogramming.com.cookiegram.dispatchers.OrderPersistanceDispatcherStub;
import com.zenoprogramming.com.cookiegram.dispatchers.PaymentDispatcherStub;
import com.zenoprogramming.com.cookiegram.dispatchers.SettingsPersistanceDispatcherStub;
import com.zenoprogramming.com.cookiegram.dispatchers.ShippingDispatcherStub;
import com.zenoprogramming.com.cookiegram.usecasemanagers.OrderManager;
import com.zenoprogramming.com.cookiegram.usecasemanagers.OrderPersistanceManager;
import com.zenoprogramming.com.cookiegram.usecasemanagers.PaymentManager;
import com.zenoprogramming.com.cookiegram.usecasemanagers.SettingsPersistanceManager;
import com.zenoprogramming.com.cookiegram.usecasemanagers.ShippingManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookieGram
{
   static SettingsPersistanceManager settingsPersistanceManager;
   static OrderPersistanceManager orderPersistanceManager;
   static ShippingManager shippingManager;
   static PaymentManager paymentManager;
   static OrderManager orderManager;

   public static void main (String[] args)
   {
      SpringApplication.run(CookieGram.class, args);
   }

   public static PaymentManager instanceOfPaymentManager ()
   {
      System.out.println("injecting PaymentDispatcherStub");
      if (paymentManager == null) {
         paymentManager = new PaymentDispatcherStub();
      }
      return paymentManager;
   }

   public static OrderPersistanceManager instanceOfOrderPersistanceManager ()
   {
      System.out.println("OrderPersistanceDispatcherStub");
      if (orderPersistanceManager == null) {
         orderPersistanceManager = new OrderPersistanceDispatcherStub();
      }
      return orderPersistanceManager;

   }

   public static SettingsPersistanceManager instanceOfSettingsPersistanceManager ()
   {
      System.out.println("injecting SettingsPersistanceDispatcher");
      if (settingsPersistanceManager == null) {
         settingsPersistanceManager = new SettingsPersistanceDispatcherStub();
      }
      return settingsPersistanceManager;
   }

   public static ShippingManager instanceOfShippingManager ()
   {
      System.out.println("injecting ShippingDispatcherStub");
      if (shippingManager == null) {
         shippingManager = new ShippingDispatcherStub();
      }
      return shippingManager;
   }

   public static OrderManager instanceOfOrderManager ()
   {
      if (orderManager == null) {
         orderManager = new OrderManager();
      }
      return orderManager;
   }

}
