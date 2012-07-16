package com.msi.manning.chapter8.SimpleNotMessage;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleNotMessage extends Activity
{
 NotificationManager myNotificationManager;
 private static final int NOTIFICATION_ID = 1;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Button myGen = (Button)findViewById(R.id.button_cn);
    myGen.setOnClickListener(myGenOnClickListener);
    Button myClear = (Button)findViewById(R.id.button_dn);
    myClear.setOnClickListener(myClearOnClickListener);
}

private void GenerateNotification(){
  
    myNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    Notification.Builder builder = new Notification.Builder(this);
    builder.setContentTitle ("Attention Please!");
    builder.setTicker("*** Notification ***");
    builder.setSmallIcon(R.drawable.notand);
    builder.setContentText("- Message for the User -");
    
    Intent notificationIntent = new Intent(this, SimpleNotMessage.class);
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
    builder.setContentIntent(contentIntent);

    myNotificationManager.notify(NOTIFICATION_ID, builder.getNotification());
}

Button.OnClickListener myGenOnClickListener =
 new Button.OnClickListener(){
  public void onClick(View v) {
   GenerateNotification();
  }
 };

Button.OnClickListener myClearOnClickListener =
 new Button.OnClickListener(){

  public void onClick(View v) {
   myNotificationManager.cancel(NOTIFICATION_ID);
  }
 
};
}