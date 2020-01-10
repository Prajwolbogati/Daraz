package com.example.daraz.model;

public class Item {
    int imgid;
    String desc;
    float price;

    public Item(int imgid, String desc, float price) {
        this.imgid = imgid;
        this.desc = desc;
        this.price = price;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
