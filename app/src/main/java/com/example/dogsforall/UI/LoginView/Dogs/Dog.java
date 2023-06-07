package com.example.dogsforall.UI.LoginView.Dogs;

import android.graphics.Bitmap;

public class Dog {

    private String name;
    private String Image;
    private String description;
    private String old;
    private Integer weight;
    private String iol;

    public Dog(String name, String image, String description, String old, Integer weight, String iol) {
        this.name = name;
        Image = image;
        this.description = description;
        this.old = old;
        this.weight = weight;
        this.iol = iol;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return Image;
    }

    public String getDescription() {
        return description;
    }

    public String getOld() {
        return old;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getIol() {
        return iol;
    }
}
