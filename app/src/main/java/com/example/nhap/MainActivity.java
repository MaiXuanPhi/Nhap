package com.example.nhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nhap.Alarm.BaoThucMainActivity;
import com.example.nhap.DeleteEditAddRecyclerView.RecyclerActitity;
import com.example.nhap.YoutubeLayout.YoutubeActivity;
import com.example.nhap.button_animation.ButtonAnimation;
import com.example.nhap.fragment.FragmentMainActivity;
import com.example.nhap.Fragment_Tablayout_Viewpager.FragmentTablayoutViewpagerMainActivity;
import com.example.nhap.NavigationDrawerTablayoutViewPager.NavigationDrawerTablayoutViewPagerMainActivity;
import com.example.nhap.Notification.NotificationMainActivity;
import com.example.nhap.imageFile.ImageActivity;
import com.example.nhap.recyclerviewhozitatol.RecylerviewHz;
import com.example.nhap.splash.SplashScreen;
import com.example.nhap.zingmp3.ZingMp3Activity;

public class MainActivity extends AppCompatActivity {

    Button bt_bao_thuc, bt_fragment, bt_fragment_tablayout_viewpager, bt_drawnavigation_tablayout_viewpager,
    bt_notification,bt_recyclerviewhz, bt_animation, bt_splashscreen, bt_editDeleteAddRecyclerView,
    btnImageActivity, btnZingmp3, btnLayoutYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_bao_thuc = findViewById(R.id.bt_baothuc);
        bt_fragment = findViewById(R.id.bt_fragment);
        bt_fragment_tablayout_viewpager = findViewById(R.id.bt_fragment_tablayout_viewpager);
        bt_drawnavigation_tablayout_viewpager = findViewById(R.id.bt_drawnavigation_tablayout_viewpager);
        bt_notification = findViewById(R.id.bt_notification);
        bt_recyclerviewhz = findViewById(R.id.bt_recyclerviewhz);
        bt_animation = findViewById(R.id.buttonanimation);
        bt_splashscreen = findViewById(R.id.bt_splashscreen);
        bt_editDeleteAddRecyclerView = findViewById(R.id.btnEditDeleteAddRecylerView);
        btnImageActivity = findViewById(R.id.btnImageActivyti);
        btnZingmp3 = findViewById(R.id.btnZingMp3);
        btnLayoutYoutube = findViewById(R.id.btnYoutube);

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

        bt_recyclerviewhz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecylerviewHz.class);
                startActivity(i);
            }
        });

        bt_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ButtonAnimation.class);
                startActivity(i);
            }
        });

        bt_splashscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(i);
            }
        });

        bt_editDeleteAddRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecyclerActitity.class);
                startActivity(i);
            }
        });

        btnImageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(i);
            }
        });

        btnZingmp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZingMp3Activity.class);
                startActivity(intent);
            }
        });

        btnLayoutYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
                startActivity(intent);
            }
        });
    }
}