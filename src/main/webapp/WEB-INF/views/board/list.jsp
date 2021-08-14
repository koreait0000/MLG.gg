<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>--%>
<div id="board_container">
    <div id="board_lists">
        <table>
            <tbody id="datalist">
            <c:forEach var="item" items="${list}" varStatus="status">
                <tr onclick="location.href='detail?board_no=${item.board_no}'">
                    <td>${item.title}</td>
                    <td>${item.user_no}</td>
                    <td>${item.views}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="pagearr">
        <c:forEach begin="1" end="${page}" var="num">
            <span onclick="order(${num})">${num}</span>
        </c:forEach>
    </div>
    <div id="search_infos">
        <div id="writebtn">
            <button onclick="location.href='write'">write</button>
        </div>
        <div id="searches">
            <form id="search_form">
                <input type="text" id="searchval" name="searchval">
                <input type="button" value="검색" onclick="order(${cpage})">
            </form>
            <div id="sap">
                <select id="orderly" onchange="order(${cpage})">
                    <option selected value="board_no">번호순</option>
                    <option value="regdt">최신순</option>
                    <option value="views">조회순</option>
                </select>
            </div>
        </div>
    </div>
</div>