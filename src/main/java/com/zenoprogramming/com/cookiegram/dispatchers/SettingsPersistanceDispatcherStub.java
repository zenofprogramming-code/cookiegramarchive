package com.zenoprogramming.com.cookiegram.dispatchers;
import com.zenoprogramming.com.cookiegram.domainobjects.Settings;
import com.zenoprogramming.com.cookiegram.usecasemanagers.SettingsPersistanceManager;
import java.time.LocalDate;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class SettingsPersistanceDispatcherStub implements
    SettingsPersistanceManager
{
   private Settings settings = new Settings();

   public SettingsPersistanceDispatcherStub ()
   {
      System.out.println("In constructor of SettingsPersistanceDispatcherStub where we are creating arbitrary test data for settings");
      settings.setNumBakesPerDayDefault(2);
      settings.getSpecialDates().put(LocalDate.now().plusDays(3), 0);
      settings.setStandardCookieCost(19.99);
      settings.setStandardTax(4.99);
      settings.getValidCountries().add("Canada");
   }

   @Override
   public void saveSettings (Settings settings)
   {
      this.settings = settings;
   }

   @Override
   public Settings getSettings ()
   {
      return this.settings;
   }

}
