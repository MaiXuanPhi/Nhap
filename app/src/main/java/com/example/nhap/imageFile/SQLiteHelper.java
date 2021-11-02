package com.example.nhap.imageFile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public SQLiteHelper(@Nullable Context context) {
        super(context, "db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS FOOD (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR, PRICE VARCHAR, IMAGE BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS FOOD");
            onCreate(db);
        }
    }

    public List<ImageObject> getAll (){
        db = getReadableDatabase();
        List<ImageObject> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM FOOD", null);
        while (cursor.moveToNext()){
            Integer id = cursor.getInt(0);
            String title = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new ImageObject(id, title, price, image));
        }
        return list;
    }

    public void insertData(String name, String price, byte[] img){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("PRICE", price);
        values.put("IMAGE", img);
        db.insert("FOOD", null, values);
    }

    public void delete(int id){
        db = getWritableDatabase();
        db.delete("FOOD", "ID = ?", new String[]{id+""});
    }
}
