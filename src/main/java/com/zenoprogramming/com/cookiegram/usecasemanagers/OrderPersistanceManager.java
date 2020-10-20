/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author smirich
 */
public interface OrderPersistanceManager
{
   boolean saveOrderToRepository (CookieOrder cookieOrder);

   CookieOrder getOrderByOrderNumber (int orderNumber);

   List<CookieOrder> getAllOrders ();

   List<CookieOrder> getDaysBakingOrders (LocalDate date);

   List<CookieOrder> getDaysShippingOrders (LocalDate date);

   int getNextOrderNumber ();
}
