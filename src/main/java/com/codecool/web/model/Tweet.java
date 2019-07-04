package com.codecool.web.model;

import java.time.LocalTime;

public final class Tweet {
    private String tweet;
    private final LocalTime date = LocalTime.now();;
    private String user;

    public Tweet() {
        this.tweet = "";
        this.user = "";
    }

    public String getTweet() {
        return tweet;
    }

    public LocalTime getDate() {
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
}
