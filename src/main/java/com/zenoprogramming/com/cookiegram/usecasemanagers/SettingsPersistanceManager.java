/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenoprogramming.com.cookiegram.usecasemanagers;
import com.zenoprogramming.com.cookiegram.domainobjects.Settings;
/**
 *
 * @author smirich
 */
public interface SettingsPersistanceManager
{
   void saveSettings (Settings settings);

   Settings getSettings ();
}
