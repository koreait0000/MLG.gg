<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>결과창</title>
</head>
<body>

    <c:forEach items="${data}" var="mtList">
        <div>
            <img onclick="getGameId(${mtList.gameId})" class="ChampionImg" src="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${mtList.champion_name}_0.jpg">
        </div>
        <br>
    </c:forEach>


    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>모달</h2>
            </div>
            <div class="close-area">X</div>
                <div class="content">

                </div>
        </div>
    </div>
</body>
</html>
