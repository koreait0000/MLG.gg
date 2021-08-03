<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <meta charset="UTF-8">
    <title>결과창</title>


    <div id="testScroll">
        <c:forEach items="${data}" var="mtList">
            <div id="testScrollItem">
                <img id="mainChampion" onclick="getGameId(${mtList.gameId})" class="ChampionImg" src="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${mtList.champion_name}_0.jpg">
            </div>
            <br>
        </c:forEach>
    </div>


    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <span>
                    <h2 id="winTitle">WIN</h2>
                    <h2 id="loseTitle">LOSE</h2>
                </span>
            </div>
            <div class="close-area">X</div>
                <div class="content">

                </div>
        </div>
    </div>


