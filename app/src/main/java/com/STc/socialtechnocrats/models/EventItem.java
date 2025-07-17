package com.STc.socialtechnocrats.models;

import androidx.recyclerview.widget.RecyclerView;

import java.util.SplittableRandom;

public class EventItem{
    String title;
    int imageResId;

    public EventItem(String title, int imageResId){
        this.title=title;
        this.imageResId=imageResId;
    }
    public String getTitle(){
        return title;
    }
    public int getImageResId(){
        return imageResId;
    }
}
