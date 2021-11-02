package com.example.nhap.recyclerviewhozitatol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nhap.R;

public class RecylerviewHz extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview_hz);
        recyclerView = findViewById(R.id.recycler_view);


    }
}