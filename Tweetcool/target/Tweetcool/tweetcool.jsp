<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tweetcool</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="tweetcool.css">
</head>
<body>
    <header>
        <h1 id="header">--|Tweetcool|--</h1>
    </header>

    <nav>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" href="#!">Active</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#!">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#!">Link</a>
            </li>
        </ul>
    </nav>

    <div id="main-content" style="display: flex; justify-content: space-between; align-items: stretch;">

        <div class="left-div">
                <p class="mini-head">-Users-</p>
            <c:forEach items="${users}" var="user">
                <p id="user-name"><a href="userlist?user=${user.getName()}">${user.getName()}</a></p><hr style="width: 90%; margin-top: 8px; margin-bottom: 8px;">
            </c:forEach>
        </div>

        <div class="middle-div">
            <p class="mini-head">-Write Tweet-</p>
            <div style=" text-align: center; margin-top: 100px;">
                <form action="userlist" method="post">
                    <p style="margin-bottom: 50px;"><input id="name" type="text" name="name" placeholder="Name..." required></p>
                    <p><textarea id="tweet" type="text" name="tweet" rows="5" placeholder="Tweet..." maxlength="150"required></textarea></p>
                    <button id="submit-button" type="submit">Send</button>
                </form>
            </div>
        </div>

        <div class="right-div">
            <p class="mini-head">-Tweets-</p>
            <c:forEach var="current" items="${users}">
                <div id="tweet-box">
                    <p style="float: left; font-size: 12px; font-weight: bold;">${current.getName()}</p>
                    <p style="float: right; font-size: 12px; font-weight: bold;">${current.getDate()}</p><br><hr>
                    <p style="margin-bottom: 0px;">${current.getTweet()}</p>
                </div>
                <hr style="width: 90%; margin-top: 8px; margin-bottom: 8px;">
            </c:forEach>
        </div>
    </div>
</body>
</html>
