package com.vivekbalachandra.gcmusage;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

import java.io.IOException;

/**
 * Created by Vivek Balachandran on 1/5/2016.
 */
public class RegistrationIntentService extends IntentService {


    private static final String TAG = "RegIntentService";
    public static final String senderId = "735386554719";
    public static String token;
    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID id = InstanceID.getInstance(this);

        try {
            Log.d(TAG,id.getId());
            // request token that will be used by the server to send push notifications
            String token = id.getToken(senderId, GoogleCloudMessaging.INSTANCE_ID_SCOPE);
            Log.d(TAG, "GCM Registration Token: " + token);
            sendRegistrationToServer(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRegistrationToServer(String tok) {
        // Add custom implementation, as needed.
        Log.d(TAG,"send this to"+token+"server");
          token=token;

    }
}

