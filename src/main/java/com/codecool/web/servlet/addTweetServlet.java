package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTweet")
public class addTweetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TweetService ts = (TweetService) req.getServletContext().getAttribute(TweetService.class.getName());
        req.getParameter("textarea");


    }
}
