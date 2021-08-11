<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-logo">
    <a class="site-logo" href="/home">
        <img src="/img/logo_main.png" alt="Homepage">
    </a>
    <button onclick="ziral()" class="btn_sial">씨발렺ㄴ</button>
</div>
<a class="header-menu-toggle" href="#0"><i class="fas fa-bars"></i></a>

<nav class="header-nav-wrap">
    <c:choose>
        <c:when test="${loginfo eq null}">
            <div class="header-nav-item">
                <a href="/user/login">Sign in</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="header-nav-item">
                <a href="/user/logout">Sign out</a>
            </div>
        </c:otherwise>
    </c:choose>
    <c:if test="${loginfo eq null}">
        <div class="header-nav-item">
            <a href="/user/join">Sign up</a>
        </div>
    </c:if>
</nav>

