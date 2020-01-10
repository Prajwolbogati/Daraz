package com.example.daraz.model;

public class Item {
    String image;
    String desc;
    float price;

    public Item(String image, String desc, float price) {
        this.image = image;
        this.desc = desc;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
