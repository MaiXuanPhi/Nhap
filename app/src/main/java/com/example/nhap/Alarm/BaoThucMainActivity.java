package com.example.nhap.Alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.nhap.R;

import java.util.Calendar;

public class BaoThucMainActivity extends AppCompatActivity {

    Button btnHenGio, btnDungLai;
    TextView txtHienThi;
    TimePicker timePicker;
    Calendar calendar;
    AlarmManager alarmManager; // trình quản lí báo thức
    PendingIntent pendingIntent; // ý định dang chờ xử lí

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_thuc_main);

        btnHenGio = findViewById(R.id.btnHenGio);
        btnDungLai = findViewById(R.id.btnDungLai);
        txtHienThi = findViewById(R.id.textView);
        timePicker = findViewById(R.id.timePicker);

        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE); // cho phép try cập vào hệ thống báo động của máy

        Intent intent = new Intent(BaoThucMainActivity.this, AlarReceiver.class);

        btnHenGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());

                int gio = timePicker.getCurrentHour(); // Lấy giờ (Kiểu int)
                int phut = timePicker.getCurrentMinute(); // Lấy phút (Kiểu int)

                String string_gio = String.valueOf(gio); // chuyển giờ thành String
                String string_phut = String.valueOf(phut);  // Chuyển phút thành String

                if (gio > 12){
                    string_gio = String.valueOf(gio - 12); // nếu giờ = 13 thì chuyển thành 1 giờ
                }
                if (phut < 10){
                    string_phut = "0"+String.valueOf(phut); // nếu phút < 10 thì thêm số 0 ở trước phút
                }
                intent.putExtra("extra","on");
                pendingIntent = PendingIntent.getBroadcast(
                        BaoThucMainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                txtHienThi.setText("Gio ban da dat la: "+string_gio+" : "+string_phut);
            }
        });

        btnDungLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHienThi.setText("Dung lai");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }
        });
    }
}