package com.STc.socialtechnocrats.sampledata;
public class NewsItem {
    private String title;
    private String category;
    private String description;
    private String date;

    public NewsItem(String title, String category, String description, String date) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
}
