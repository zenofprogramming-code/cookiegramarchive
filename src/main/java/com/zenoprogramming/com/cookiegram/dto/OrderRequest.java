package com.zenoprogramming.com.cookiegram.dto;
import java.time.LocalDate;
import lombok.*;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@Data
@AllArgsConstructor
public class OrderRequest
{
//   private int orderNumber;
   private String customerName;
   private String customerEmail;
   private String recipientName;
   private String recipientStreetAddress;
   private String recipientCity;
   private String recipientCode;
   private String recipientCountry;
   private String cookieMessage;
   private LocalDate deliveryDate;

}
