<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="index.css">
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
    <title>Tweet-Cool-Sloth</title>
</head>
<body>
    <div id="tweet-away-background">
        <div id="ta-content">
            <form class="header-info first" action="logout" method="GET">
                <h2><button>Logout</button></h2>
            </form>
            <div class="header-info second">
                <a>${sessionScope.user.name}</a>
            </div>
            <div class="header-info third">
                <a href="tweetAway.jsp">Write Cool</a>
            </div>
            <div class="header-info fourth">
                <a href="tweetView.jsp">View Cool</a>
            </div>
            <form method="POST" action="addTweet">
                <textarea name="textarea" placeholder="400 max char" maxlength="400" name="t-area" id="t-area" cols="166" rows="12" required></textarea>
                <button id="tc-submit">Submit</button>
            </form>    
        </div>
    </div>
</body>
</html>
