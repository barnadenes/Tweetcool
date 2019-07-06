package com.codecool.web.servlet;

import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addTweet")
public class addTweetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TweetService ts = (TweetService) req.getServletContext().getAttribute(TweetService.class.getName());
        String tweet = req.getParameter("textarea");
        String user = String.valueOf(req.getSession().getAttribute("user"));
        Date date = new Date();

        ts.addTweet(user, tweet, date);

        req.getRequestDispatcher("tweetAway.jsp").include(req, resp);
    }
}
