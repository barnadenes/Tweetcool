package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/filter")
public class tweetFilterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TweetService ts = (TweetService) req.getServletContext().getAttribute(TweetService.class.getName());
        String name = req.getParameter("poster");
        String date = req.getParameter("time");
        int limit = Integer.parseInt(req.getParameter("limit"));
        int offset = Integer.parseInt(req.getParameter("offset"));
        Date cDate = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            cDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Tweet> tweets = ts.mainFilter(name, cDate, limit, offset);
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("tweetView.jsp").include(req,resp);
    }
}
