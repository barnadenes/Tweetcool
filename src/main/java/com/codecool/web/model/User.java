package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public final class User {
    private final String name;
    private final List<Tweet> tweetList;

    public User(String name) {
        this.name = name;
        this.tweetList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }

}
