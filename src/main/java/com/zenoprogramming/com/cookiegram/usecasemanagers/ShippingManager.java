/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.dto.OrderRequest;
/**
 *
 * @author smirich
 */
public interface ShippingManager
{
   double getShippingCosts (OrderRequest orderRequest);

   boolean verifyValidShippingAddress (OrderRequest orderRequest);
}
