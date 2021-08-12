package com.example.nhap;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import com.example.nhap.Notification.MyApplication;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kotlinicon);
        MediaSession mediaSession = new MediaSession(this, "Tag");
        Notification notification = new Notification.Builder(this,MyApplication.CHANNEL_ID_3)
                .setSmallIcon(R.drawable.ic_music)
                .setSubText("Xuan phi")
                .setContentTitle("Title of Song")
                .setContentText("Single of Song")
                .setLargeIcon(bitmap)
                .addAction(R.drawable.ic_back, "Previous", null) // #0
                .addAction(R.drawable.ic_pause, "Pause", null)  // #1
                .addAction(R.drawable.ic_next, "Next", null)   // #2
                .setStyle(new Notification.MediaStyle().setMediaSession(mediaSession.getSessionToken()))
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,notification);

        String nhankey = intent.getExtras().getString("extra");
        Log.e("music nhan key",nhankey);
        if (nhankey.equals("on")){
            id = 1;
        }else if (nhankey.equals("off")){
            id = 0;
        }
        if (id == 1){
            mediaPlayer = MediaPlayer.create(this,R.raw.heks);
            mediaPlayer.start();
            id = 0;
        }else if (id == 0){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        Log.e("Toi trong music","Xin chao");
        return START_NOT_STICKY;
    }
}
