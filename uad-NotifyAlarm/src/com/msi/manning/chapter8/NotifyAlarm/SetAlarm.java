package com.msi.manning.chapter8.NotifyAlarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SetAlarm extends Activity {

    private NotificationManager nm;
    private int NOTIFICATION_ID;
    Toast mToast;

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        this.nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Button button = (Button) findViewById(R.id.set_alarm_button);
        button.setOnClickListener(this.mOneShotListener);

    }

    private void showNotification(int statusBarIconID, int statusBarTextID, int detailedTextID, boolean showIconOnly) {

        Intent contentIntent = new Intent(this, SetAlarm.class);
        PendingIntent theappIntent = PendingIntent.getBroadcast(SetAlarm.this, 0, contentIntent, 0);
        
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle ("Attention Please!");
        builder.setTicker("Alarm");
        builder.setSmallIcon(statusBarIconID);
        builder.setContentText("- Message for the User -");
        builder.setContentIntent(theappIntent);
        
        nm.notify(NOTIFICATION_ID, builder.getNotification());
    }

    private OnClickListener mOneShotListener = new OnClickListener() {

        public void onClick(View v) {

            Intent intent = new Intent(SetAlarm.this, AlarmReceiver.class);

            PendingIntent appIntent = PendingIntent.getBroadcast(SetAlarm.this, 0, intent, 0);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.SECOND, 30);

            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), appIntent);

            showNotification(R.drawable.alarm, R.string.alarm_message, R.string.alarm_message, false);
        }
    };

}
