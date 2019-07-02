package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        TweetService ts = (TweetService) req.getServletContext().getAttribute(TweetService.class.getName());
        List<User> users = ts.getUsers();

        for (User user : users) {
            if(!user.getName().equals(userName) || users.isEmpty()) {
                User newUser = new User(userName);
                ts.addUser(newUser);
                req.setAttribute("user", newUser);
            }
            else {
                req.setAttribute("user", user);
            }
        }
        req.getRequestDispatcher("tweetAway.html").forward(req, resp);
    }
}
