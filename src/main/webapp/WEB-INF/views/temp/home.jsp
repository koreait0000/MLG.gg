<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/home.css">
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
    <h1>제공되는 서비스</h1>
    <div class="img-container">
        <div class="img-items">
            <img class="img-open" src="https://talk.op.gg/images/game/bg_lol.jpg">
            <span class="text">
                    <h1>LEARN MORE</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://talk.op.gg/images/game/bg_ow.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://talk.op.gg/images/game/bg_pubg.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://talk.op.gg/images/game/bg_r6.jpg">
            <span class="text">
                    <h1>COMING SOON</h1>
                </span>
        </div>
    </div>
</div>
<!--##############################((((MAIN.3))))#############################-->

<!--데이터 크롤링-->
<div>
<div>
    <form action="/home" method="post">
        <input type="text" name="text" placeholder="값 입력" value="롤신챔프">
        <input type="submit" value="gogo">
    </form>
</div>
<div>
    <c:forEach var="i" items="${hrefList}" varStatus="status">
        <a href="<c:out value="${i}"></c:out>"><img src="${ImgList[status.index]}" width="500px" height="300px"><br>
            <c:out value="${writerList[status.index]}"></c:out>&nbsp;&nbsp;<c:out value="${cntList[status.index]}"></c:out><br>
            <c:out value="${titleList[status.index]}"></c:out>
        </a><br>

    </c:forEach>
</div>
</div>
<!--##############################((((MAIN.4))))#############################-->
<div>
    <h1>무엇이든 물어보세요</h1>
    <div class="mainPage4">
        <div class="main4-section1">
            <img class="yumi" src="/img/video/yumi.gif">
            <span class="text">
                    <h1>GM.오구범<br><br>무엇이든 물어보세요
                    </h1>
                </span>
        </div>
        <div class="balloon">
        </div>
    </div>
</div>
<script src="main.js"></script>

<%--<script src="/js/sfm.js"></script>--%>

