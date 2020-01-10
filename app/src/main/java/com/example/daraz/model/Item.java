package com.example.daraz.model;

public class Item {
    String  itemName;
    String itemImage;
    float Price;

    public Item(String itemName, String itemImage, float price) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        Price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
