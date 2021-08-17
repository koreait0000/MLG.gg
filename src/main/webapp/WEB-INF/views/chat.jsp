<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script defer src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script defer src="/js/temp/etc.js"></script>
    <link rel="stylesheet" href="/css/chat.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>
<body>
<div id="chat_container">
    <div id="chating" class="chating"></div>
    <div id="sortDiv">
        <div id="yourName" class="inputTable">
            <input type="hidden" value="${loginfo.user.lname}" name="userName" id="userName">
        </div>
        <div id="yourMsg">
            <div class="inputTable">
                <input id="chatting" placeholder="  메시지 입력...">
                <button onclick="send()" id="sendBtn"><i class="fab fa-facebook-messenger"></i></button>
            </div>
        </div>
    </div>
</div>
</body>
