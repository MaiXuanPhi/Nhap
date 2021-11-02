package com.example.nhap.imageFile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.nhap.R;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity2 extends AppCompatActivity {

    ListView listView;
    List<ImageObject> list;
    ImageAdapter adapter;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        listView = findViewById(R.id.listView2);

        sqLiteHelper = new SQLiteHelper(ImageActivity2.this);
        list = sqLiteHelper.getAll();

        adapter = new ImageAdapter(ImageActivity2.this, list);
        listView.setAdapter(adapter);
    }
}