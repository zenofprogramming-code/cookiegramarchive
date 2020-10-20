package com.zenoprogramming.com.cookiegram.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@AllArgsConstructor
@Data
public class PaymentResponse
{
   private boolean success;
   private String returnMessageToUser;
}
