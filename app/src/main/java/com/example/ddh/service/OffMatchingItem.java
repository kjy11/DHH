package com.example.ddh.service;

import android.graphics.drawable.Drawable;

public class OffMatchingItem {

    private Drawable img_festival;

    public OffMatchingItem(Drawable image) {
        this.img_festival = image;
    }

    public Drawable getImg_festival() {
        return img_festival;
    }

    public void setImg_festival(Drawable img_festival) {
        this.img_festival = img_festival;
    }
}
