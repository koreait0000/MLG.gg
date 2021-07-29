<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- CSS
     ================================================== -->
    <link rel="stylesheet" href="/css/test.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">
    <!-- script
      ================================================== -->
<%--    <script src="js/modernizr.js"></script>--%>
</head>

<body id="top">
<!--화면에서 로그인정보 쓸때 EL식으로 loginfo사용-->
<c:set value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}" var="loginfo" scope="session"></c:set>

<%--<tiles:insertAttribute name="preloader"></tiles:insertAttribute>--%>

<header class="s-header" id="s-head">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</header>

<aside>
    <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
</aside>

<section>
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</section>

<footer class="s-footer">
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</footer>

<%--<script src="/js/preloader.js"></script>--%>
<%--<script src="js/main.js"></script>--%>
<script src="/js/test.js"></script>
<script src="/js/<tiles:getAsString name="js"/>.js"></script>
</body>

</html>