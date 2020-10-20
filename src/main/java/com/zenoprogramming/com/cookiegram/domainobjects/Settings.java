package com.zenoprogramming.com.cookiegram.domainobjects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.Data;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@Data
public class Settings
{
   private int numBakesPerDayDefault;
   HashMap<LocalDate, Integer> specialDates = new HashMap<LocalDate, Integer>();
   private double standardCookieCost;
   private double standardTax;
   private List<String> validCountries = new ArrayList<String>();


}
