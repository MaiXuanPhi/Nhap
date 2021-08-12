package com.example.nhap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import androidx.constraintlayout.widget.Constraints;

public class AlarReceiver extends BroadcastReceiver {
          // Bộ thu cảnh báo      phát thu sóng
    @Override
    // ví dụ đồng hồ đếm 11 h sẽ gọi đến class này
    public void onReceive(Context context, Intent intent) {
        Log.e("Toi trong Receiver","Xin chao");
        String chuoi_string = intent.getExtras().getString("extra");
        Log.e("Chuoi ba truyen",chuoi_string);
        Intent myIntent = new Intent(context,Music.class); // intent đến class Music
        myIntent.putExtra("extra",chuoi_string);
        context.startService(myIntent);

    }
}
