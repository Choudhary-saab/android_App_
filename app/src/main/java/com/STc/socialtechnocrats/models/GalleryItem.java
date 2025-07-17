package com.STc.socialtechnocrats.models;

public class GalleryItem {
    String title;
    int imageResId;

    public GalleryItem(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}
