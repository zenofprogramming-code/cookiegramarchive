package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import com.zenoprogramming.com.cookiegram.dto.PaymentResponse;
import com.zenoprogramming.com.cookiegram.usecasemanagers.PaymentManager;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class PaymentDispatcherStub implements PaymentManager
{

   @Override
   public PaymentResponse makePayment (CookieOrder cookieOrder)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
