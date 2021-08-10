<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sliding_box">
    <i class="left fas fa-arrow-left"></i>
    <div class="sliding_view">
        <div id="sliding_containner">
            <c:forEach items="${data}" var="mtList">
                <div class="sliding_list" onclick="stopscroll()">
                    <div class="top-film">
                        <div class="half blank"></div>
                        <div class="blank"></div>
                        <div class="blank"></div>
                        <div class="blank"></div>
                        <div class="half blank"></div>
                    </div>
                    <div class="slide_center">
                        <div class="side-film"></div>
                        <div class="img_cotainer">
                            <img id="mainChampion" onclick="getGameId(${mtList.gameId},`${mtList.champion_name}`)"
                                 class="ChampionImg"
                                 src="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${mtList.champion_name}_0.jpg">
                        </div>
                        <div class="side-film"></div>
                    </div>
                    <div class="bottom-film">
                        <div class="half blank"></div>
                        <div class="blank"></div>
                        <div class="blank"></div>
                        <div class="blank"></div>
                        <div class="half blank"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <i class="right fas fa-arrow-left"></i>
</div>
<div id="who_play">'${param.search_id}'의 검색결과</div>
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

