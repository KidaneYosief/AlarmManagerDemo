package com.kidane.yosief.AlarmManagerDemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

/**
 * Created by kidane yosief on 11/20/2015.
 */
public class NotifyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(), MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification mNotify = new Notification.Builder(this)
                .setContentTitle("Follow!")
                .setContentText("Follow U Iowa")
                .setSmallIcon(R.drawable.sky)
                .setContentIntent(pIntent)
                .setSound(sound)
                .addAction(0, "Load Website", pIntent)
                .build();

        mNM.notify(1, mNotify);
    }
}
