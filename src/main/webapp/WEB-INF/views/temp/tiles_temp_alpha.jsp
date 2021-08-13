<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MLG.GG</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" href="/css/temp/main.css">
    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<!--화면에서 로그인정보 쓸때 EL식으로 loginfo사용-->
<c:set value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}" var="loginfo" scope="session"></c:set>
<tiles:insertAttribute name="preloader"></tiles:insertAttribute>
<div id="highest">
    <header class="s-header" id="s-head">
        <tiles:insertAttribute name="header"></tiles:insertAttribute>
    </header>
    <aside>
        <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
    </aside>
    <div id="chatting_modal">
        <tiles:insertAttribute name="chat"></tiles:insertAttribute>
    </div>
    <div id="templete_container" class="scroll_container" onclick="closeSideBar()">
        <section class="scroll_item">
            <tiles:insertAttribute name="content"></tiles:insertAttribute>
        </section>
<%--        <footer class="s-footer scroll_item" id="footer">--%>
<%--            <tiles:insertAttribute name="footer"></tiles:insertAttribute>--%>
<%--        </footer>--%>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/js/temp/main.js"></script>
<script defer src="/js/<tiles:getAsString name="js"/>.js"></script>

</body>
</html>