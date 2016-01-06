package com.vivekbalachandra.gcmusage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Vivek Balachandran on 1/5/2016.
 */
public class MyGcmListenerService extends GcmListenerService {
    public static final int MESSAGE_NOTIFICATION_ID = 435345;
    String message=null;

    public void onMessageReceived(String from, Bundle data) {
         message = data.getString("message");
        Log.d("gcm", "From: " + from);
        Log.d("gcm", "Message: " + message);
        createNotification(from, message);

    }
    private void createNotification(String title, String body) {
       //create a notification lanch an activity or get data etc
        Context context=getApplicationContext();
        NotificationCompat.Builder mBuilder=new  NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("This is the Title");
        mBuilder.setContentText("Message:" + message);
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID, mBuilder.build());
        Intent gotolancher=new Intent(context,MainActivity.class);
        gotolancher.putExtra("Messege",message);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        gotolancher,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
       mBuilder.setContentIntent(resultPendingIntent);

    }
}