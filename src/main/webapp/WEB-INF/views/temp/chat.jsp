<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table class="inputTable">
            <tr>
                <th><input id="chatting" placeholder="  메시지 입력.."></th>
                <th style="width: 100px">
                    <button onclick="send()" id="sendBtn">보내기</button>
                    <button onclick="closeChat()" id="closeBtn">X</button>
                </th>
            </tr>
        </table>
    </div>
</div>