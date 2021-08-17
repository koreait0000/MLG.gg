<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MLG.GG</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="/css/temp/alpha.css">
    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">
</head>
<body>
<c:set value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}" var="loginfo" scope="session"></c:set>

<tiles:insertAttribute name="preloader"></tiles:insertAttribute>

<div id="alpha" class="alpha scroll_container">
    <header>
        <tiles:insertAttribute name="header"></tiles:insertAttribute>
    </header>

    <tiles:insertAttribute name="content"></tiles:insertAttribute>

    <footer class="scroll_item">
        <tiles:insertAttribute name="footer"></tiles:insertAttribute>
    </footer>
</div>
<script defer src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TimelineMax.min.js'></script>
<script defer src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js'></script>
<script defer src='https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js'></script>
<script defer src='https://cdnjs.cloudflare.com/ajax/libs/gsap/3.3.3/gsap.min.js'></script>
<script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script defer src="/js/<tiles:getAsString name="js"/>.js"></script>
<script defer src="/js/temp/alpha.js"></script>
</body>
</html>