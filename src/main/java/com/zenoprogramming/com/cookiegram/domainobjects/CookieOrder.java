package com.zenoprogramming.com.cookiegram.domainobjects;
import java.time.LocalDate;
import lombok.*;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookieOrder
{
   private int orderNumber;
   private String customerName;
   private String customerEmail;
   private String recipientName;
   private String recipientStreetAddress;
   private String recipientCity;
   private String recipientCode;
   private String recipientCountry;
   private String cookieMessage;
   private LocalDate shipDate;
   private double cost;
   private double shippingCosts;
   private double taxes;
   private double totalOwed;
}
