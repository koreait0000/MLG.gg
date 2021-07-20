<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

board list home
<div>
    <table>
        <th>글번호</th>
        <th>제목</th>
        <th>작성일</th>
        <th>작성자</th>
        <th>조회수</th>
        <tbody id="datalist">
            <c:forEach var="item" items="${list}" varStatus="status">
            <tr>
                <td>${item.board_no}</td>
                <td onclick="location.href='detail?board_no=${item.board_no}'">${item.title}</td>
                <td>${item.regdt}</td>
                <td>${item.user_no}</td>
                <td>${item.views}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div id="page">
        <c:forEach begin="1" end="${page}" var="i">
            <span onclick="order(${i})">${i}</span>
        </c:forEach>
    </div>
    <select id="orderly" onchange="order(${cpage})">
        <option selected value="board_no">번호순</option>
        <option  value="regdt">날짜순</option>
        <option value="views">조회순</option>
    </select>
    <select id="pcnt" onchange="order(${cpage})">
        <option selected value="10">10</option>
        <option  value="20">20</option>
        <option value="30">30</option>
    </select>

    <button onclick="location.href='write'">write</button>
</div>
