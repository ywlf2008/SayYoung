package com.yw.sayyoung.sayyoung.core.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Goods implements Parcelable {
    private String imgUrl;
    private String name;
    private float price;
    private int count;

    public Goods() {
    }

    public Goods(String imgUrl, String name, float price) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
        this.count = 1;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imgUrl);
        dest.writeString(this.name);
        dest.writeFloat(this.price);
        dest.writeInt(this.count);
    }

    protected Goods(Parcel in) {
        this.imgUrl = in.readString();
        this.name = in.readString();
        this.price = in.readFloat();
        this.count = in.readInt();
    }

    public static final Parcelable.Creator<Goods> CREATOR = new Parcelable.Creator<Goods>() {
        @Override
        public Goods createFromParcel(Parcel source) {
            return new Goods(source);
        }

        @Override
        public Goods[] newArray(int size) {
            return new Goods[size];
        }
    };
}
