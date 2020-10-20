package com.zenoprogramming.com.cookiegram.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@Data
@AllArgsConstructor
public class OrderRequestResponse
{
//   private RequestResponseType responseType;
   private boolean success = true;
   private String returnMessageToUser;
   private String htmlPage;

}
