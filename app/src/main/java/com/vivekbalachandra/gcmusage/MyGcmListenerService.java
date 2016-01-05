package com.vivekbalachandra.gcmusage;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Vivek Balachandran on 1/5/2016.
 */
public class MyGcmListenerService extends GcmListenerService {
    public static final int MESSAGE_NOTIFICATION_ID = 435345;
    public void onMessageReceived(String from, Bundle data) {
        String message = data.getString("message");
        Log.d("gcm", "From: " + from);
        Log.d("gcm", "Message: " + message);
        createNotification(from, message);

    }
    private void createNotification(String title, String body) {
       //create a notification lanch an activity or get data etc
    }
}