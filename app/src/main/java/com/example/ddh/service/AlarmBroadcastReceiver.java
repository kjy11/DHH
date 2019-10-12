package com.example.ddh.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.ddh.AlarmActivity;
import com.example.ddh.R;


public class AlarmBroadcastReceiver extends BroadcastReceiver {
    private final static int NOTICATION_ID = 222;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmBroadcastReceiver", "onReceive");
        PowerManager manager = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = manager.newWakeLock(PowerManager.FULL_WAKE_LOCK  |
                PowerManager.ACQUIRE_CAUSES_WAKEUP |
                PowerManager.ON_AFTER_RELEASE, "My:Tag");
        wakeLock.acquire(5000);
        boolean bScreenOn = manager.isScreenOn();

        if(bScreenOn){
            Log.d("popup", "Screen ON");
            Intent popup = new Intent(context, AlarmActivity.class);
            popup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(popup);
        }else{
            Log.d("popup", "Screen OFF");
            Intent popup = new Intent(context, AlarmActivity.class);
            popup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(popup);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, context.getString(R.string.notification_channel_id))
                .setSmallIcon(R.drawable.ic_love_p_64px) //알람 아이콘
                .setContentTitle("Title")  //알람 제목
                .setContentText("Text") //알람 내용
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); //알람 중요도

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTICATION_ID, builder.build()); //알람 생성
        wakeLock.release();
        wakeLock = null;
    }
}

