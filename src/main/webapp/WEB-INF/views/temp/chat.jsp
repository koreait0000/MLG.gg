<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="chat_container">
    <div id="chating" class="chating">
    </div>
    <div id="yourName">
        <table class="inputTable">
            <tr>
                <th><input type="text" placeholder="nickname" name="userName" id="userName"></th>
                <th>
                    <button onclick="chatName()" id="startBtn">사용</button>
                </th>
            </tr>
        </table>
    </div>
    <div id="yourMsg">
        <table class="inputTable">
            <tr>
                <th><input id="chatting" placeholder="메시지 입력.."></th>
                <th>
                    <button onclick="send()" id="sendBtn">보내기</button>
                </th>
            </tr>
        </table>
    </div>
</div>
<%--    <script crossorigin src="https://unpkg.com/@daily-co/daily-js"></script>--%>
<%--    <script>--%>
<%--        callFrame = window.DailyIframe.createFrame();--%>
<%--        callFrame.join({ url: 'https://mlg.daily.co/hello-daily' });--%>
<%--    </script>--%>
