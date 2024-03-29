<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="index.css">
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&amp;display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
    <title>Tweet-Cool-Sloth</title>
</head>
<body>
    <div id="tweet-view-background">
        <div id="ta-content">
            <form class="header-info first" action="logout" method="GET">
                <h2><button>Logout</button></h2>
            </form>
            <div class="header-info second">
                <a>${sessionScope.user}</a>
            </div>
            <div class="header-info third">
                <a href="tweetAway.jsp">Write Cool</a>
            </div>
            <div class="header-info fourth">
                <a href="tweetView.jsp">View Cool</a>
            </div>
            <div id="center-box-middle">
                <div id="box-background-container">
                    <div id="center-options">
                      <form action="filter" method="post">
                        <div class="all-options">
                            <select  name="limit" class="select-div">
                                <option value="10">Limit:</option>
                                <option value="5">5</option>
                                <option value="2">2</option>
                                <option value="1">1</option>
                            </select>
                        </div>
                        <div class="all-options">
                            <select  name="offset" class="select-div">
                                <option value="0">Offset:</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <div class="all-options">
                            <select name="poster" class="select-div">
                                <option value="user">Poster:</option>
                                <c:forEach items="${sessionScope.users}" var="user">
                                    <option value="${user}">${user}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="all-options">
                            <label for="time"></label>
                            <input style="font-size: 0.7vw;" class="select-div" type="date" name="time" id="time">
                        </div>
                        <button class="submit">Search</button>
                      </form>
                    </div>
                </div>
                <div class="tweet-list-container">
                    <form action="filter" method="post">
                        <c:forEach var="tweet" items="${tweets}">
                            <div class="inner-tl-container">
                                <p><c:out value="${tweet.user}"/></p>
                                <p><c:out value="${tweet.date}"/></p>
                            </div>
                            <p class="p-text"><c:out value="${tweet.tweet}"/></p>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
