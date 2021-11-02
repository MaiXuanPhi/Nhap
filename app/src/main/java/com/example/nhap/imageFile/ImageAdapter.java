package com.example.nhap.imageFile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhap.R;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    Context context;
    List<ImageObject> imageObjectList;

    public ImageAdapter(Context context, List<ImageObject> imageObjectList) {
        this.context = context;
        this.imageObjectList = imageObjectList;
    }

    @Override
    public int getCount() {
        return imageObjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inf = ((ImageActivity2)context).getLayoutInflater();
        view = inf.inflate(R.layout.item_image, null);

        TextView tvTitle, tvPrice;
        ImageView imageView;

        tvTitle = view.findViewById(R.id.tvTitleImage);
        tvPrice = view.findViewById(R.id.tvPriceImage);
        imageView = view.findViewById(R.id.imgImage);

        tvTitle.setText(imageObjectList.get(position).title);
        tvPrice.setText(imageObjectList.get(position).price);

        Bitmap bitmap = BitmapFactory.decodeByteArray(imageObjectList.get(position).img, 0, imageObjectList.get(position).img.length);
        imageView.setImageBitmap(bitmap);

        return view;
    }
}
