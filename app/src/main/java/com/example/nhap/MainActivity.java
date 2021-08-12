package com.example.nhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nhap.fragment.FragmentMainActivity;
import com.example.nhap.Fragment_Tablayout_Viewpager.FragmentTablayoutViewpagerMainActivity;
import com.example.nhap.NavigationDrawerTablayoutViewPager.NavigationDrawerTablayoutViewPagerMainActivity;
import com.example.nhap.Notification.NotificationMainActivity;

public class MainActivity extends AppCompatActivity {

    Button bt_bao_thuc, bt_fragment, bt_fragment_tablayout_viewpager, bt_drawnavigation_tablayout_viewpager,
    bt_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_bao_thuc = findViewById(R.id.bt_baothuc);
        bt_fragment = findViewById(R.id.bt_fragment);
        bt_fragment_tablayout_viewpager = findViewById(R.id.bt_fragment_tablayout_viewpager);
        bt_drawnavigation_tablayout_viewpager = findViewById(R.id.bt_drawnavigation_tablayout_viewpager);
        bt_notification = findViewById(R.id.bt_notification);

        bt_bao_thuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BaoThucMainActivity.class);
                startActivity(i);
            }
        });

        bt_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentMainActivity.class);
                startActivity(i);
            }
        });

        bt_fragment_tablayout_viewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentTablayoutViewpagerMainActivity.class);
                startActivity(i);
            }
        });

        bt_drawnavigation_tablayout_viewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NavigationDrawerTablayoutViewPagerMainActivity.class);
                startActivity(i);
            }
        });

        bt_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NotificationMainActivity.class);
                startActivity(i);
            }
        });
    }
}