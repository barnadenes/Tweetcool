package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public final class User {
    private String name;
    private String tweet;
    private String date;
    private List<String> tweetList;
    private List<String> dateList;

    public User(String name, String tweet, String date) {
        this.name = name;
        this.tweet = tweet;
        this.date = date;
        this.tweetList = new ArrayList<>();
        this.dateList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTweet() {
        return tweet;
    }

    public String getDate() {
        return date;
    }

    public List<String> getTweetList() {
        return tweetList;
    }

    public List<String> getDateList() {
        return dateList;
    }
}
