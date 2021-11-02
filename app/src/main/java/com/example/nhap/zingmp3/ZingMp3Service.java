package com.example.nhap.zingmp3;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.io.IOException;

public class ZingMp3Service extends Service {

    MediaPlayer mediaPlayer;

    String[] mangMusic = {"https://drive.google.com/uc?export=download&id=14P7yPko-GPFo4Cvk5agSiNO3rXbjyExK",
    "https://drive.google.com/uc?export=download&id=1gK8tLmRZMHTZ9XRY8OkHm31_Xfidm3dD",
    "https://drive.google.com/uc?export=download&id=1yKkYlnP5Q8-R7O9SEjeN6DMF8QRbdym3"};
    int index;

    public ZingMp3Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(">>>>>", "onCreate");
        mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(mangMusic[index]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.e("Music>>>>","on erroo");
                return false;
            }
        });

//        mediaPlayer.getDuration();
//        mediaPlayer.seekTo(1); // vi tri cua bai hat

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action = intent.getAction();
        index = intent.getIntExtra("index", 0);
        switch (action){
            case "run":
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else {
                    mediaPlayer.start();
                }
                break;
            default:

//                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                try {
//                    mediaPlayer.setDataSource(mangMusic[index]);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                mediaPlayer.prepareAsync();
//                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        mediaPlayer.start();
//                    }
//                });
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}