package com.yw.sayyoung.sayyoung.core.bean;

public class Goods {
    private String imgUrl;
    private String name;
    private float price;

    public Goods() {
    }

    public Goods(String imgUrl, String name, float price) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
