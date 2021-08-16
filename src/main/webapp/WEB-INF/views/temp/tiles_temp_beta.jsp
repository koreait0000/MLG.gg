<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MLG.GG</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/temp/beta.css">
    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<div id="beta" class="beta">
    <!--화면에서 로그인정보 쓸때 EL식으로 loginfo사용-->
    <c:set value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}" var="loginfo"
           scope="session"></c:set>

    <tiles:insertAttribute name="preloader"></tiles:insertAttribute>

    <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>

    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<script src='https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/3.3.3/gsap.min.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script defer src="/js/<tiles:getAsString name="js"/>.js"></script>
<script defer src="/js/temp/beta.js"></script>
<script defer src="/js/temp/etc.js"></script>
</body>
</html>