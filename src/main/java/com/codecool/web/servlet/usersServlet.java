package com.codecool.web.servlet;

import com.codecool.web.exceptions.UserNotFoundException;
import com.codecool.web.model.User;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userlist")
public class usersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TweetService ts = new TweetService();
//        req.setAttribute("users", users);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String tweet = (String) req.getParameter("tweet");

        req.getRequestDispatcher("tweetcool.jsp").forward(req, resp);
    }
}
