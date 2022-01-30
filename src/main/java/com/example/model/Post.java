package com.example.model;

public class Post {
    private int id;
    private String text;
    private String day;
    private boolean reminder;

    public Post() {
    }

    public Post(int id, String text, String day, boolean reminder) {
        this.id = id;
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }
}
