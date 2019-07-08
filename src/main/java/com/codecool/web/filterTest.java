package com.codecool.web;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.TweetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class filterTest {
    private Tweet tweet;
    private Date date;
    private List<Tweet> ts = TweetService.getInstance().getTweets();
    private TweetService tweetService = TweetService.getInstance();
    private List<Tweet> testTweet;

    @BeforeEach
    void setUp() {
        testTweet = new ArrayList<>();
        date = new Date();
        tweet = new Tweet();
        tweet.setUser("JusticeLord-lol");
        tweet.setTweet("Muhahahah-ha");
        tweet.setDate(new Date());
        testTweet.add(tweet);
        ts.add(tweet);
    }

    @AfterEach
    void tearDown() {
        tweet = null;
        testTweet = null;
    }

    @Test
    void testLimitFilter() {
        assertEquals(1, tweetService.limitFilter(1, 0).size());
    }

    @Test
    void testOffsetFilter() {
        assertEquals(1, tweetService.offsetFilter(0).size());
    }

    @Test
    void getPosterName() {
        assertEquals("JusticeLord-lol", tweet.getUser());
    }

    @Test
    void getTweet() {
        assertEquals("Muhahahah-ha", tweet.getTweet());
    }

    @Test
    void getDate() {
        assertEquals(date, tweet.getDate());
    }
}
