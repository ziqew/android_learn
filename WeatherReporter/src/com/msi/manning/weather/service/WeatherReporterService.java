package com.msi.manning.weather.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.msi.manning.weather.IWeatherReporter;
import com.msi.manning.weather.data.DBHelper;
import com.msi.manning.weather.data.WeatherRecord;
import com.msi.manning.weather.data.DBHelper.Location;

public class WeatherReporterService extends WeatherAlertService {
   private final class WeatherReporter 
     extends IWeatherReporter.Stub {
      public String getWeatherFor(String zip) throws RemoteException {
         WeatherRecord record = loadRecord(zip);
         return record.getCondition().getDisplay();
      }
      public void addLocation(String zip, String city, String region) 
        throws RemoteException {
         DBHelper db = new DBHelper(WeatherReporterService.this);
         Location location = new Location();
         location.alertenabled = 0;
         location.lastalert = 0;
         location.zip = zip;
         location.city = city;
         location.region = region;
         db.insert(location);
      }
   }; 
   public IBinder onBind(Intent intent) {
      return new WeatherReporter();
   }
}
