package com.example.dogsforall.UI.LoginView.Pay;

import android.graphics.drawable.Drawable;

public class Pay_viewpageitem {
    private int image;
    private String descr;

    public Pay_viewpageitem(int image, String descr) {
        this.image = image;
        this.descr = descr;
    }

    public int getImage() {
        return image;
    }

    public String getDescr() {
        return descr;
    }
}
