package com.example.nhap.imageFile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import androidx.annotation.Nullable;

import com.example.nhap.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    Bitmap bitmap;
    Context context;
    SQLiteDatabase db;
    SQLiteStatement p;
    public SQLiteHelper(@Nullable Context context) {
        super(context, "db", null, 9);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS FOOD (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR, PRICE VARCHAR, IMAGE BLOB)");
        p = db.compileStatement("insert into FOOD(NAME, PRICE, IMAGE) values(?, ?, ?)");

        insertDataFood("a1", "834756834", R.drawable.a1);
        insertDataFood("a2", "834756834", R.drawable.a2);
        insertDataFood("a3", "834756834", R.drawable.a3);
    }

    public void insertDataFood(String name, String price, int img) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), img);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        byte[] data = stream.toByteArray();

        p.bindString(1, name);
        p.bindString(2, price);
        p.bindBlob(3, data);
        p.execute();
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
