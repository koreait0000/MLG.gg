<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-logo">
    <a class="site-logo" href="/home">
        <img src="/img/logo_main.png" alt="Homepage">
    </a>
</div>
<a class="header-menu-toggle" href="#0"><i class="fas fa-bars"></i></a></ul>

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
    <div class="header-nav-item">
        <a href="" onclick="movesmooth('hell')">about</a>
    </div>
    <c:if test="${loginfo eq null}">
        <div class="header-nav-item">
            <a href="/user/join">Sign up</a>
        </div>
    </c:if>
</nav>

