package com.example.nhap.Notification;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.example.nhap.R;

public class MyApplication extends Application {
    public static final String CHANNEL_ID = "CHANNEL";
    public static final String CHANNEL_ID_2 = "CHANNEL_2";
    public static final String CHANNEL_ID_3 = "CHANNEL_3";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_MIN; // độ ưu tiên
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

                CharSequence name_2 = getString(R.string.channel_name_2);
                String description_2 = getString(R.string.channel_description_2);
                int importance_2 = NotificationManager.IMPORTANCE_MAX;
                @SuppressLint("WrongConstant") NotificationChannel channel_2 = new NotificationChannel(CHANNEL_ID_2, name_2, importance_2);
                channel_2.setDescription(description_2);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this

            CharSequence name_3 = getString(R.string.channel_name_3);
            String description_3 = getString(R.string.channel_description_3);
            int importance_3 = NotificationManager.IMPORTANCE_MAX; // độ ưu tiên
            @SuppressLint("WrongConstant") NotificationChannel channel_3 = new NotificationChannel(CHANNEL_ID_3, name_3, importance_3);
            channel.setDescription(description_3);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null){
                notificationManager.createNotificationChannel(channel);
                notificationManager.createNotificationChannel(channel_2);
                notificationManager.createNotificationChannel(channel_3);
            }
        }
    }
}
