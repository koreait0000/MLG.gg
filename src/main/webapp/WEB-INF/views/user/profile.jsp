<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div id="profile_container" class="scroll_item">

    <img id="blurImg" src="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${pudlol.mastery[0].champion_name}_0.jpg">
    <div id="profile_main">
        <div id="profile_iconLv">
            <img id="profile_img"
                 src="http://ddragon.leagueoflegends.com/cdn/11.16.1/img/profileicon/${pudlol.profileIconId}.png" ;>
            <h2 id="profile_lv">${pudlol.summonerLevel}Level</h2>
            <h3 id="profile_nm">${pud.lname}</h3>
        </div>
        <div id="wirAndfol">
            <h3>${writelist}개</h3>
            <h3>${woolist.size()}팔로우</h3>
            <h3>${winglist.size()}팔로워</h3>
            <div>
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
            </div>
        </div>
    </div>
    <div id="tiersDiv">
        <c:forEach var="tier" items="${pudlol.rank}" varStatus="status">
            <div id="tierDiv${status.index}" class="rankDiv">
                <img class="tierImg" src="/img/lolTiers/${pudlol.rank[status.index].tier}.png">
                <h3>
                    <c:choose>
                    <c:when test="${status.index eq 0}">
                        Team Rank
                    </c:when>
                    <c:when test="${status.index eq 1}">
                        Solo Rank
                    </c:when>
                    </c:choose>
                </h3>
                <h3>
                        ${pudlol.rank[status.index].tier} ${pudlol.rank[status.index].rank}
                        ${pudlol.rank[status.index].leaguePoints}점
                </h3>
                <h3>
                    WIN : ${pudlol.rank[status.index].wins}판 LOSE : ${pudlol.rank[status.index].losses}판
                </h3>
            </div>
        </c:forEach>
    </div>
    <%--<div class="masteryInfoDiv">--%>
    <%--    <c:forEach begin="0" end="2" varStatus="status">--%>
    <%--        <div class="masterystat">--%>
    <%--            --%>
    <%--        </div>--%>
    <%--    </c:forEach>--%>
    <%--</div>--%>
</div>

<div id="masteryDiv" class="scroll_item" style="background-image: url('https://previews.123rf.com/images/andreykuzmin/andreykuzmin1701/andreykuzmin170100011/70096126-%EC%98%9B-%ED%95%B4%EC%83%81%EC%A7%80%EB%8F%84-%EB%B0%B0%EA%B2%BD.jpg');
                     background-repeat: no-repeat;
                     background-size: cover;">
    <c:forEach begin="0" end="2" varStatus="status">
        <div class="masteryimg">
            <img id="masteryImg${status.index}" class="masteryImg"
                 src="http://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/${pudlol.mastery[status.index].champion_name}.png">
                <%--            <div>--%>
                <%--                    ${pudlol.mastery[status.index].champion_KRname}--%>
                <%--            </div>--%>
            <h2>
                레벨 : ${pudlol.mastery[status.index].championLevel}
            </h2>
            <h2>
                포인트 : ${pudlol.mastery[status.index].championPoints}
            </h2>
        </div>
    </c:forEach>
</div>

