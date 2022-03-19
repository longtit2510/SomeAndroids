package com.example.firstandroidpj.model;

public class Stadium {
    private int img;
    private String name, diachi;

    public Stadium() {
    }

    public Stadium(int img, String name, String diachi) {
        this.img = img;
        this.name = name;
        this.diachi = diachi;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
