package com.codecool.web.service;

import com.codecool.web.exceptions.UserNotFoundException;
import com.codecool.web.model.User;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TweetService {
    private static TweetService tw = new TweetService();
    private List<User> users = new ArrayList<>();


    public static TweetService getInstance () {
        return tw;
    }
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
    public void updateUser(User user, String tweet) {
        user.getDateList().add(getTweetTime());
        user.getTweetList().add(tweet);
        System.out.println("updatebe van!");
    }

    // time getter;
    public static String getTweetTime() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }


    public void finalAdd(User user, String tweet) {
        if(!tw.getUsers().isEmpty()) {
            for(User user3 : tw.getUsers()) {
                if (user3.getName().equals(user.getName())) {
                    updateUser(user3, tweet);
               }
                else {
                    addUser(user);
                }
            }
         }
        else {
            addUser(user);
        }
    }

    @Override
    public String toString() {
        return "TweetService{" +
            "users=" + users +
            '}';
    }

}
