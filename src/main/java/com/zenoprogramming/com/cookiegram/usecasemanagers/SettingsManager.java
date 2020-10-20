package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.CookieGram;
import com.zenoprogramming.com.cookiegram.domainobjects.Settings;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class SettingsManager
{
   private SettingsPersistanceManager settingsPersistanceManager = CookieGram.instanceOfSettingsPersistanceManager();
   private Settings settings = settingsPersistanceManager.getSettings();



   public void changeNumBakesPerDayDefault (int numDays)
   {
      settings.setNumBakesPerDayDefault(numDays);
      settingsPersistanceManager.saveSettings(settings);
   }

   public void addSpecialDate (LocalDate date, int numBakes)
   {
      HashMap<LocalDate, Integer> specialDates = settings.getSpecialDates();
      specialDates.put(date, numBakes);
      settingsPersistanceManager.saveSettings(settings);
   }

   public void addValidShippingCountry (String country)
   {
      settings.getValidCountries().add(country);
   }

   public void removeValidShippingCountry (String country)
   {
      List<String> validCountries = settings.getValidCountries();
      validCountries.remove(country);
   }
}
