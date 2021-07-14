<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="/css/index.css">
  <link rel="stylesheet" type="text/css" href="/css/header.css">
  <link rel="stylesheet" type="text/css" href="/css/main.css">
  <link rel="stylesheet" type="text/css" href="/css/chat.css">
  <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="/css/<tiles:getAsString name="css"/>.css">


</head>
<body>
<!--화면에서 로그인정보 쓸때 EL식으로 loginfo사용-->
<c:set value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}" var="loginfo" scope="session"></c:set>
<header>
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
</header>
<aside>
  <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
</aside>
<main>
  <tiles:insertAttribute name="content"></tiles:insertAttribute>

</main>
<footer>
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</footer>
<script defer
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
<script defer src="/js/chat.js"></script>
<script defer src="/js/sidebar.js"></script>

<script defer src="/js/<tiles:getAsString name="js"/>.js"></script>
</body>
</html>