package com.codecool.web.service;

import com.codecool.web.exceptions.UserNotFoundException;
import com.codecool.web.model.Tweet;
import com.codecool.web.model.User;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public final class TweetService {
    private final List<User> users = new ArrayList<>();

    // getter.
    public List<User> getUsers() {
        return users;
    }

    // new user to list.
    public void addUser(User user) {
        users.add(user);
    }

    // get user by name.
    public User getUser(User user) {
          if(!users.isEmpty() || users != null) {
              for (User user1 : users) {
                  if (user1.getName().equals(user.getName())) {
                      return user1;
                  } else {
                      return null;
                  }
              }
          }
        return null;
    }

    // adds tweet to user.
    public void addTweet(User user, Tweet tweet) {
        user.getTweetList().add(tweet);
    }


    // time getter;
    public String getTweetTime() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

}
