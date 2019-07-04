package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.List;

public final class TweetService {
    private final List<Tweet> tweets = new ArrayList<>();

    // get all user.
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        for (Tweet tweet : tweets) {
            users.add(tweet.getUser());
        }
        return users;
    }

    // new user to list.
    public void addUser(String user) {
        Tweet tweet = new Tweet();
        tweet.setUser(user);
        tweets.add(tweet);
    }

    // get tweets by name.
    public List<Tweet> nameFilter(String userName) {
        List<Tweet> tbn = new ArrayList<>();

        for (Tweet tweet : tweets) {
            if(tweet.getUser().equals(userName)) {
                tbn.add(tweet);
            }
        }
        return tbn;
    }

    //get one tweet by username.
    private Tweet getTweetByName(String userName) {
        for (Tweet tweet : tweets) {
            if(tweet.getUser().equals(userName) && tweet.getTweet().equals("")) {
                return tweet;
            }
        }
        return null;
    }

    // checks if the user is registered
    public Boolean isRegistered(String userName) {
        for (Tweet tweet : tweets) {
            if(tweet.getUser().equals(userName) && tweet.getTweet().equals("")) {
                return true;
            }
        }
        return false;
    }

    // create new tweet.
    public void addTweet(String userName, String tweet) throws NullPointerException{
        if(isRegistered(userName)) {
            for (String user : getUsers()) {
                getTweetByName(user).setTweet(tweet);
            }
        }
        else if(!isRegistered(userName)) {
            Tweet newTweet = new Tweet();
            newTweet.setUser(userName);
            newTweet.setTweet(tweet);
            tweets.add(newTweet);
        }
    }
}
