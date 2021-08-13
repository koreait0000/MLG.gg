<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div id="profile_container">
    <div id="profile_main">
        <div id="wirAndfol">
            ${writelist}개
            ${woolist.size()}팔로우
            ${winglist.size()}팔로워
        </div>
        <img id="profile_img"
             src="http://ddragon.leagueoflegends.com/cdn/11.16.1/img/profileicon/${pudlol.profileIconId}.png" ;>
        <div id="profile_lv">${pudlol.summonerLevel}Level</div>
        <div id="profile_nm">${pud.lname}</div>
    </div>
    <div id="tiersDiv">
        <c:forEach var="tier" items="${pudlol.rank}" varStatus="status">
            <div id="tierDiv${status.index}" class="rankDiv">
                <img class="tierImg" src="/img/lolTiers/${pudlol.rank[status.index].tier}.png">
                <div>
                    ${pudlol.rank[status.index].tier} ${pudlol.rank[status.index].rank}
                    ${pudlol.rank[status.index].leaguePoints}점
                </div>
                <div>
                    WIN : ${pudlol.rank[status.index].wins}판 LOSE : ${pudlol.rank[status.index].losses}판
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <c:choose>
        <c:when test="${loginfo.user.user_no eq pud.user_no}"></c:when>
        <c:otherwise>
            <c:set var="isfollow" value="${false}"></c:set>
            <c:forEach items="${winglist}" var="wingitem">
                <c:if test="${wingitem.uid eq loginfo.user.uid}">
                    <c:set var="isfollow" value="${true}"></c:set>
                </c:if>
            </c:forEach>
            <button onclick="follow(${loginfo.user.uid},${pud.user_no})" id="profile_follow">
                <c:choose>
                    <c:when test="${isfollow}">언팔로우</c:when>
                    <c:otherwise>팔로우</c:otherwise>
                </c:choose>
            </button>
        </c:otherwise>
    </c:choose>
    <div id="masteryDiv">
        <c:forEach begin="0" end="2" varStatus="status">
            <img class="masteryImg" src="http://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/${pudlol.mastery[status.index].champion_name}.png">
        </c:forEach>
    </div>
</div>
