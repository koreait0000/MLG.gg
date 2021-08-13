<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/temp/home.css">
<!--##############################((((MAIN.1))))#############################-->
<div class="before-load">
    <video muted autoplay loop>
        <source class="sample-video" src="/img/video/lolVideo2.mp4">
    </video>
    <div class="before-load-text">
        <button class="before-load-btn"><a href="#">JOIN</a></button>
    </div>
</div>
<!--##############################((((MAIN.2))))#############################-->
<div>
    <h1 class="lightH1"><span class="light">SERVICE</span></h1>
    <div class="img-container">
        <div class="img-items">
            <img class="img-open" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Alistar_9.jpg">
            <span class="text">
                    <h1>LEARN MORE</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/DrMundo_7.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ekko_11.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Zac_2.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
    </div>
</div>
<!--##############################((((MAIN.3))))#############################-->

<!--데이터 크롤링-->
<%--<div>
    <h1 class="lightH1"><span class="light">리뷰 영상</span></h1>
<div class="search-container">
    <form action="lolhome" method="post" class="search-box">
        <input type="hidden" value="롤신챔프">
        <input type="text" name="text" class="search-text" placeholder="검색어 입력">
        <button class="search-btn" type="submit">검색</button>
    </form>
</div>
<div>
    <c:forEach var="i" items="${hrefList}" varStatus="status">
        <a href="<c:out value="${i}"></c:out>">
            <img src="${ImgList[status.index]}" width="500px" height="300px">
        </a>
    </c:forEach>
</div>
</div>--%>

<script src="main.js"></script>

<%--<script src="/js/sfm.js"></script>--%>

