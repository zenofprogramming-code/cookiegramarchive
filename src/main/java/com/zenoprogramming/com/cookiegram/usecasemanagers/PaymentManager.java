package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.domainobjects.CookieOrder;
import com.zenoprogramming.com.cookiegram.dto.PaymentResponse;
/**
 *
 * @author smirich
 */
public interface PaymentManager
{
   PaymentResponse makePayment (CookieOrder cookieOrder);
}
