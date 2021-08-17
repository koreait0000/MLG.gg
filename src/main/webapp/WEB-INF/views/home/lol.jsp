<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="before-load-text">
    <button class="before-load-btn" onclick="location.href='#main3'">
        <a>
            <span id="blb_under" class="light">
                <i class="fas fa-angle-double-down"></i>
            </span>
            <div id="sfm">Scroll for more</div>
        </a>
    </button>
</div>
<!--##############################((((MAIN.1))))#############################-->
<div class="before-load scroll_item">
    <div class="video_con">
        <video width="100%" height="100%" muted autoplay loop>
            <source class="sample-video" src="/img/video/lolVideo2.mp4">
        </video>
        <div class="img_back">
            <img width="100%" height="100%" class="img_sena"
                 onclick="location.href='https://na.leagueoflegends.com/ko-kr/'"
                 src="https://nexus.leagueoflegends.com/wp-content/uploads/2019/12/Ask_Riot_Banner_Usernames_Senna_hvowppm9hhlrbouy2eu4.jpg">
            <div class="gtl">GO TO <br>LEAGUE OF LEGEND</div>
        </div>

    </div>
</div>
<!--##############################((((MAIN.2))))#############################-->
<div class="scroll_item">
    <h1 class="lightH1"><span class="light">SERVICE</span></h1>
    <div class="img-container">
        <div class="img-items">
            <a href="lol/user_s"><img class="img-open"
                                      src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Alistar_9.jpg">
            </a>
            <span class="text">
                    <h1>롤 전적</h1>
                    <h1>LEARN MORE</h1>
                </span>
        </div>
        <div class="img-items">
            <a href="lol/item"><img class="img-open"
                                    src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ekko_11.jpg">
            </a><span class="text">
                <h1>롤 아이템</h1>
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <a href="lol/champion"><img class="img-open"
                                        src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/DrMundo_7.jpg"></a>
            <span class="text">
                    <h1>롤 챔피언</h1>
                    <h1>COMING SOON</h1>
                </span>
        </div>
    </div>
</div>
<!--##############################((((MAIN.3))))#############################-->
<div class="scroll_item" id="main3">
    <h1 class="lightH1"><span class="light">ROTATION</span></h1>
    <div class="youtube-container">
        <div class="carousel">
            <div class="btn btn-back hidden">
                <i class="fas fa-arrow-left"></i>
                <i class="fas fa-chevron-left left-indicator"></i>
            </div>
            <div class="viewbox">
                <div class="track">
                    <c:forEach var="i" items="${Rotation}" varStatus="stat">
                        <c:if test="${stat.index eq 0}">
                            <div class="slide active">
                                <span class="light _img"> </span>
                                <img class="images"
                                     src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${i.champion_name}_0.jpg">
                                <div class="lightH1 chm_name"><span class="light">${i.champion_name}</span></div>
                            </div>
                        </c:if>
                        <c:if test="${stat.index ne 0}">
                            <div class="slide ">
                                <span class="light _img"></span>
                                <img class="images"
                                     src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${i.champion_name}_0.jpg">
                                <div class="lightH1 chm_name"><span class="light">${i.champion_name}</span></div>
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
                <c:forEach var="i" items="${Rotation}" varStatus="stat">
                    <c:if test="${stat.index eq 0}">
                        <div class="dot active"></div>
                    </c:if>
                    <c:if test="${stat.index ne 0}">
                        <div class="dot"></div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>



