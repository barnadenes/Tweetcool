package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TweetService {
    private final List<Tweet> tweets = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

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
    public void addTweet(String userName, String tweet, Date date) throws NullPointerException{
        if(isRegistered(userName)) {
            for (String user : getUsers()) {
                getTweetByName(user).setTweet(tweet);
                getTweetByName(user).setDate(date);
            }
        }
        else if(!isRegistered(userName)) {
            Tweet newTweet = new Tweet();
            newTweet.setUser(userName);
            newTweet.setTweet(tweet);
            newTweet.setDate(date);
            tweets.add(newTweet);
        }
    }

    // offset filter
    private List<Tweet> offsetFilter(int offset) {
        List<Tweet> offsetList = new ArrayList<>();
        if(!tweets.isEmpty()) {
            for (int i = offset; i < tweets.size(); i++) {
                offsetList.add(tweets.get(i));
            }
            return offsetList;
        }
        return new ArrayList<>();
    }

    // limit & offset filter
    public List<Tweet> limitFilter(int limit, int offset)  {
        List<Tweet> limitedList = new ArrayList<>();
        if(!offsetFilter(offset).isEmpty()) {
            for (int i = 0; i < limit; i++) {
                limitedList.add(offsetFilter(offset).get(i));
            }
            return limitedList;
        }
        return new ArrayList<>();
    }

    // name, limit & offset filter
    public List<Tweet> nameFilter(String userName, int limit, int offset) {
        List<Tweet> tbn = new ArrayList<>();
        if(!limitFilter(limit, offset).isEmpty()) {
            for (Tweet tweet : limitFilter(limit, offset)) {
                if(tweet.getUser().equals(userName)) {
                    tbn.add(tweet);
                }
            }
            return tbn;
        }
        return new ArrayList<>();
    }

    // date, limit & time filter
    public List<Tweet> timeFilter(String afterDate, int limit, int offset) throws ParseException {
        List<Tweet> resultList = new ArrayList<>();
        Date date = sdf.parse(afterDate);

        for (int i = 0; i < limitFilter(limit, offset).size(); i++) {
            if(limitFilter(limit, offset).get(i).getDate().after(date)) {
                resultList.add(limitFilter(limit, offset).get(i));
            }
            return resultList;
        }
        return new ArrayList<>();
    }

    public List<Tweet> fullFilter(List<Tweet> tl, String name, int limit, int offset, String afterDate) {
        return null;
    }
}
