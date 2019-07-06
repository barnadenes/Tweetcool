package com.codecool.web.servlet;

import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        TweetService ts = (TweetService) req.getServletContext().getAttribute(TweetService.class.getName());
        List<String> users = ts.getUsers();

        HttpSession oldSession = req.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession newSession = req.getSession(true);

        if(ts.getUsers().contains(userName)) {
            newSession.setAttribute("user", userName);
        }
        else {
            ts.adduser(userName);
            newSession.setAttribute("user", userName);
        }

        newSession.setAttribute("users", users);
        req.getRequestDispatcher("tweetAway.jsp").forward(req, resp);
    }
}
