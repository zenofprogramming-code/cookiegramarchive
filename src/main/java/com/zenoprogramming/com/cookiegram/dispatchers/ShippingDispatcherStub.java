package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.CookieGram;
import com.zenoprogramming.com.cookiegram.domainobjects.Settings;
import com.zenoprogramming.com.cookiegram.dto.OrderRequest;
import com.zenoprogramming.com.cookiegram.usecasemanagers.ShippingManager;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class ShippingDispatcherStub implements ShippingManager
{
   @Override
   public double getShippingCosts (OrderRequest orderRequest)
   {
      System.out.println("ShippingDispatcherStub: getShippingCosts called and 9.99 arbitrarily returned");
      return 9.99;
   }

   @Override
   public boolean verifyValidShippingAddress (OrderRequest orderRequest)
   {
      System.out.println("ShippingDispatcherStub: verifyValidShippingAddress called and checked against countries in settings");
      Settings settings = CookieGram.instanceOfSettingsPersistanceManager().getSettings();
      return (settings.getValidCountries().contains(orderRequest.getRecipientCountry()));
   }

}
