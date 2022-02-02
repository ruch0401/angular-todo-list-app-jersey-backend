package com.example.model;

public class Post {
    private String text;
    private String day;
    private boolean reminder;

    public Post() {
    }

    public Post(String text, String day, boolean reminder) {
        this.text = text;
        this.day = day;
        this.reminder = reminder;
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
