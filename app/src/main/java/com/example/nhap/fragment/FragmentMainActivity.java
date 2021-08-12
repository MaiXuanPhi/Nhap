package com.example.nhap.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nhap.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentMainActivity extends AppCompatActivity {
    Button bt_gr2, bt_truyen;
    BottomNavigationView bot;
    EditText ed_truyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        bt_gr2 = findViewById(R.id.bt_fr22);
        bot = findViewById(R.id.bottomnavi);
        bt_truyen = findViewById(R.id.bt_truyen);
        ed_truyen = findViewById(R.id.ed_truyen);

        bt_gr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.rightfragment,RightFragment.newInstance()).commit();
            }
        });

        bot.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.it_rfr:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.rightfragment,RightFragment.newInstance()).commit();
                        item.setChecked(true);
                        Log.e("1","1");
                        break;
                    case R.id.it_rfr2:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.rightfragment,RightFragment2.newInstance()).commit();
                        item.setChecked(true);
                        Log.e("2","2");
                        break;
                }
                return false;
            }
        });

        bt_truyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi = ed_truyen.getText().toString();
                FragmentManager fragmentManager = getSupportFragmentManager();
                RightFragment2 fragment2 = (RightFragment2) fragmentManager.findFragmentById(R.id.rightfragment);
                LeftFragment leftFragment = (LeftFragment) fragmentManager.findFragmentById(R.id.leftfragment);
                fragment2.tv.setText(chuoi);
                leftFragment.ed.setText(chuoi);
            }
        });
    }
}