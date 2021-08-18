<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="part1">
    <div id="who_play">'${param.search_id}'의 검색결과</div>

    <div class="carousel">
        <div class="btn btn-back hidden">
            <i class="fas fa-arrow-left"></i>
            <i class="fas fa-chevron-left left-indicator"></i>
        </div>
        <div class="viewbox">
            <div class="track">
                <c:forEach var="i" items="${data}" varStatus="stat">
                    <c:if test="${stat.index eq 0}">
                        <div class="slide active">
                            <img class="images"  onclick="getGameId(${i.gameId},`${i.champion_name}`)"
                                 src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${i.champion_name}_0.jpg">
                            <div class="lightH1 chm_name"><span class="light">${i.champion_KRname}</span></div>
                        </div>
                    </c:if>
                    <c:if test="${stat.index ne 0}">
                        <div class="slide ">
                            <img class="images" onclick="getGameId(${i.gameId},`${i.champion_name}`)"
                                 src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${i.champion_name}_0.jpg">
                            <div class="lightH1 chm_name"><span class="light">${i.champion_KRname}</span></div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="btn btn-next">
            <i class="fas fa-arrow-right"></i>
            <i class="fas fa-chevron-right right-indicator"></i>
        </div>
        <div class="nav-indicator">
            <c:forEach var="i" items="${data}" varStatus="stat">
                <c:if test="${stat.index eq 0}">
                    <div class="dot active"></div>
                </c:if>
                <c:if test="${stat.index ne 0}">
                    <div class="dot"></div>
                </c:if>
            </c:forEach>
        </div>
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
</div>

