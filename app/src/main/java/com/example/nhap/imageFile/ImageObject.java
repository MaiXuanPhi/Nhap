package com.example.nhap.imageFile;

public class ImageObject {
    public Integer id;
    public String title, price;
    public byte[] img;

    public ImageObject(Integer id, String title, String price, byte[] img) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.img = img;
    }
}
