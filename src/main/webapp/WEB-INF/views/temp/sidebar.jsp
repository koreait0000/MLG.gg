<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 사이드바 -->
<div id="gnb" onclick="closeSideBar()">
    <img id="gnb_img" src="/img/btn_search.png">
    <div>
        <ul class="hero-social" id="hero-left">
            <c:if test="${loginfo.user.uid ne null}">
                <li class="hero-social__title">
                    <a href="/user/profile?uid=${loginfo.user.uid}">
                        <div class="social-item">My</div>
                    </a>
                </li>
                <li class="hero-social__title">
                    <a onclick="openChat()">
                        <div class="social-item">CHAT</div>
                    </a>
                </li>
            </c:if>
            <li class="hero-social__title">
                <a href="/board/list" title="">
                    <div class="social-item">BOARD</div>
                </a>
            </li>
            <li>
                <a id="liconimg" href="/lol" title="">
                    <div class="social-item"><img src="/img/logo_lol.png"></div>
                </a>
            </li>
        </ul> <!-- end hero-social -->
    </div>

</div>
<!-- 스크롤 바-->
<div class="hero-scroll">
    <a href="#about" class="scroll-link smoothscroll">
        Scroll For More
    </a>
</div>
<div class="ss-go-top">
    <a class="smoothscroll" title="Back to Top" onclick="movesmooth('heaven')">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
            <path d="M12 0l8 9h-6v15h-4v-15h-6z"/>
        </svg>
    </a>
</div>
