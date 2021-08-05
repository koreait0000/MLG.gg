<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="testScroll">
    <c:forEach items="${data}" var="mtList">
        <div id="testScrollItem">
            <img id="mainChampion" onclick="getGameId(${mtList.gameId})" class="ChampionImg"
                 src="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${mtList.champion_name}_0.jpg">
        </div>
        <br>
    </c:forEach>
</div>
<div id="modal" class="modal-overlay">
    <div class="modal-window">
        <span class="title">
            <span id="winTitle">WIN</span>
            <span id="loseTitle">LOSE</span>
        </span>
        <span class="close-area">X</span>
        <div class="content"></div>
    </div>
</div>


