<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap_nav">
    <div class="logo_main">
        <a href="/home"><img src="/img/logo_main2.png"></a>
    </div>
        <div class="menu_lol"><a href="/lol">League Of Legend</a></div>
    <div class="menu_battle"><a href="/bg">BATTLEGROUNDS</a></div>
    <div><a href="/board/list">COMMUNITY</a></div>
    <c:choose>
        <c:when test="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.authenticated eq true}">
            <div class="btn_login"><a href="/user/logout">sign out</a></div>
        </c:when>
        <c:otherwise>
            <div class="btn_login"><a href="/user/login">sign in</a></div>
        </c:otherwise>
    </c:choose>
</div>