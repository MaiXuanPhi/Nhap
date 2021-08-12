package com.example.nhap.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.media.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.nhap.BaoThucMainActivity;
import com.example.nhap.MainActivity;
import com.example.nhap.R;
import com.example.nhap.fragment.FragmentMainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationMainActivity extends AppCompatActivity {

    public String tit = "hfsffkshdfksdhfksdhfksdjhfksjhfksdhfksdjhfksdhfkshdkfhsdkfhksdhfksjdhfksdjhfksdhfkjsdhkjfshdkjfhsdkfhsdkf";

    // có khai báo name trong manifests
    // có khai báo cha con trong manifests
    // có import trong grapdle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_main);

        Button btnSendNotification = findViewById(R.id.btn_send_notification);
        Button btnSendNotification2 = findViewById(R.id.btn_send_notification_2);
        Button btnCustomNotification = findViewById(R.id.btn_custom_notification);
        Button btnSendNotification3 = findViewById(R.id.btn_custom_notification_media);

        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });

        btnSendNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification2();
            }
        });

        btnCustomNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomNotification();
            }
        });

        btnSendNotification3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomNotification3();
            }
        });
    }

    public void sendCustomNotification3(){
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
    }


    private void sendNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher); // mếu co ảnh thuộc .xml ko dùng dc
        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, NotificationMainActivity.class);
// Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
// Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(getNotificationId(), PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title push notifcation")
                .setContentText(tit)
                .setSmallIcon(android.R.drawable.ic_delete)  // ko có tác dụng
                .setStyle(new Notification.BigTextStyle().bigText(tit))  // dùng để hiện thị hết nội dung text
                .setLargeIcon(bitmap)
                .setColor(Color.RED)
                .setAutoCancel(true) // khi click vào thông báo thì nó sẽ mất thông báo đó
                .setContentIntent(resultPendingIntent)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (notificationManager != null){
//            notificationManager.notify(getNotificationId(),notification);
//        }
    }
    private void sendNotification2() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kotlinicon);

        Intent notifyIntent = new Intent(this, FragmentMainActivity.class);
// Set the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
// Create the PendingIntent
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                this, getNotificationId(), notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        Notification notification = new Notification.Builder(this, MyApplication.CHANNEL_ID_2)
                .setContentTitle("Title push notifcation 2")
                .setContentText("Message notification 2")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(bitmap)
                .setStyle(new Notification.BigPictureStyle().bigPicture(bitmap))
                .setContentIntent(notifyPendingIntent)
                .setColor(Color.RED)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (notificationManager != null){
//            notificationManager.notify(getNotificationId(),notification);
//        }
    }

    private int getNotificationId() {
        return (int) new Date().getTime();
    }

    private void sendCustomNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kotlinicon);
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        notificationLayout.setTextViewText(R.id.tv_title_custom_notifcation,"Hello");
        notificationLayout.setTextViewText(R.id.tv_message_custom_notification,"Hello world");
//        notificationLayout.setImageViewResource(R.id.img_custom_notification_expanded,R.drawable.kotlinicon);
        notificationLayout.setImageViewBitmap(R.id.img_custom_notification_expanded,bitmap);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdf.format(new Date());
        notificationLayout.setTextViewText(R.id.tv_time_custom_notification,strDate);
        Notification notification = new Notification.Builder(this, MyApplication.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayout) // khi custom thêm ảnh lớn phải có lệnh này
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
    }
}