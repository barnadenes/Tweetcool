package com.codecool.web.model;

import java.util.Date;

public final class Tweet {
    private final String text;
    private final Date date;

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
