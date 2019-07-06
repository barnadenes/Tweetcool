package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TweetService {
    private final List<Tweet> tweets = new ArrayList<>();
    private List <String> userList = new ArrayList<>();
    private List<Tweet> empty = new ArrayList<>();

    // get all user.
    public List<String> getUsers() {
        return  userList;
    }

    // new user to list.
    public void adduser(String name) {
        userList.add(name);
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
    private Boolean isRegistered(String userName) {
        if(userList.contains(userName)) {
            return true;
        }
        return false;
    }

    // create new tweet.
    public void addTweet(String userName, String tweet, Date date) {
        if(isRegistered(userName)) {
            Tweet newTweet = new Tweet();
            newTweet.setUser(userName);
            newTweet.setTweet(tweet);
            newTweet.setDate(date);
            tweets.add(newTweet);
        }
    }

    // get earliest time.
    public Date getStartDate() {
        Date old;

        if(tweets.get(0).getDate() != null) {
            old = tweets.stream().map(Tweet::getDate).min(Date::compareTo).get();
            return old;
        }
        return null;
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
        else if(offset > tweets.size()) {
            return empty;
        }
        return empty;
    }

    // limit & offset filter
    public List<Tweet> limitFilter(int limit, int offset)  {
        List<Tweet> limitedList = new ArrayList<>();
        List<Tweet> offFilter = offsetFilter(offset);

        if(!offFilter.isEmpty()) {
            for (int i = 0; i < limit; i++) {
                limitedList.add(offFilter.get(i));
            }
            return limitedList;
        }
        else if(limit > offFilter.size()) {
            return offFilter;
        }
        return empty;
    }

    // name, limit & offset filter
    public List<Tweet> nameFilter(String userName, int limit, int offset) {
        List<Tweet> tbn = new ArrayList<>();
        List<Tweet> limoff = limitFilter(limit, offset);

        if(!limoff.isEmpty()) {
            for (Tweet tweet : limoff) {
                if(tweet.getUser().equals(userName)) {
                    tbn.add(tweet);
                }
            }
            return tbn;
        }
        else if(!limoff.isEmpty() && userName.equals("")) {
            return limoff;
        }
        return empty;
    }

    // tea filter
    public List<Tweet> mainFilter(String name, Date afterDate, int limit, int offset) {
        List<Tweet> resultList = new ArrayList<>();
        List<Tweet> tFilter = nameFilter(name, limit, offset);

        if(!tFilter.isEmpty() && getStartDate() != null) {
            for (Tweet tweet : tFilter) {
                if(tweet.getDate().after(afterDate)) {
                    resultList.add(tweet);
                }
            }
            return resultList;
        }
        return tFilter;
    }
}
