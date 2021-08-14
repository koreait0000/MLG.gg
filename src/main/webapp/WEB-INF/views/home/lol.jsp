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
            <a href="/lol/userSearch"><img class="img-open" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Alistar_9.jpg">
            </a>
                <span class="text">
                    <h1>롤 전적</h1>
                    <h1>LEARN MORE</h1>
                </span>
        </div>
        <div class="img-items">
            <a href="/lol/itemSearch"><img class="img-open" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ekko_11.jpg">
            </a><span class="text">
                <h1>롤 아이템</h1>
                    <h1>COMING SOON</h1>
                </span>
        </div>
        <div class="img-items">
            <img class="img-closed" src="https://ddragon.leagueoflegends.com/cdn/img/champion/splash/DrMundo_7.jpg">
            <span class="text">
                    <h1>롤 챔피언</h1>
                    <h1>COMING SOON</h1>
                </span>
        </div>
    </div>
</div>
<!--##############################((((MAIN.3))))#############################-->
<h1 class="lightH1"><span class="light">RIVIEW</span></h1>
<div class="youtube-container">

<div class="carousel">
    <div class="btn btn-back hidden">
        <i class="fas fa-arrow-left"></i>
        <i class="fas fa-chevron-left left-indicator"></i>
    </div>
    <div class="viewbox">
        <div class="track">
            <div class="slide active">
                <a href="${hrefList[0]}"><img class="images" src="${ImgList[0]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[1]}"><img class="images" src="${ImgList[1]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[2]}"><img class="images" src="${ImgList[2]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[3]}"><img class="images" src="${ImgList[3]}"></a>
            </div>
            <div class="slide active">
                <a href="${hrefList[4]}"><img class="images" src="${ImgList[4]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[5]}"><img class="images" src="${ImgList[5]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[6]}"><img class="images" src="${ImgList[6]}"></a>
            </div>
            <div class="slide">
                <a href="${hrefList[7]}"><img class="images" src="${ImgList[7]}"></a>
            </div>
        </div>
    </div>
    <div class="btn btn-next">
        <i class="fas fa-arrow-right"></i>
        <i class="fas fa-chevron-right right-indicator"></i>
    </div>
    <div class="nav-indicator">
        <div class="dot active"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
    </div>
</div>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TimelineMax.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js'></script>
<script src="main.js"></script>
<script src="/js/home/lol.js"></script>


