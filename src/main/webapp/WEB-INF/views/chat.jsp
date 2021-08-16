<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script defer src="/js/temp/etc.js"></script>
    <script defer src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="/css/chat.css" />
</head>
<body>
<div id="chat_container">
    <div id="chating" class="chating">
    </div>
    <div id="yourName">
        <table class="inputTable">
            <tr>
                <th><input type="hidden" value="${loginfo.user.lname}" name="userName" id="userName"></th>
            </tr>
        </table>
    </div>
    <div id="yourMsg">
        <div class="inputTable">
                <input id="chatting" placeholder="  메시지 입력..">
                    <button onclick="send()" id="sendBtn">보내기</button>
        </div>
    </div>
</div>
</body>