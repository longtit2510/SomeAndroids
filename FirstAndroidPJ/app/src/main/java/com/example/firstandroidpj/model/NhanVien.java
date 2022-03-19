package com.example.firstandroidpj.model;

import android.widget.ImageView;

public class NhanVien {
    private int img;
    private String name,ma;

    public NhanVien() {
    }

    public NhanVien(int img, String name, String ma) {
        this.img = img;
        this.name = name;
        this.ma = ma;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
}
