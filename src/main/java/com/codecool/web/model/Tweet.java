package com.codecool.web.model;

import java.util.Date;

public final class Tweet {
    private String tweet;
    private Date date;
    private String user;

    public Tweet() {
        this.tweet = "";
        this.user = "";
        this.date = null;
    }

    public String getTweet() {
        return tweet;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user =  user;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
