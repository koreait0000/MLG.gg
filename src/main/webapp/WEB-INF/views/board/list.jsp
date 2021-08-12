<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div id="search_infos">
        <div id="writebtn">
            <button onclick="location.href='write'">write</button>
        </div>
        <div id="searches">
            <div id="search_form">
                <form action="" method="post">
                    <input type="text" name="searchval">
                    <select id="searchwhat" onchange="order(${cpage})">
                        <option selected value="t">제목</option>
                        <option value="u">작성자</option>
                        <option value="tau">제목+작성자</option>
                    </select>
                    <input type="submit" value="검색">
                </form>
            </div>
            <div id="sap">
                <select id="orderly" onchange="order(${cpage})">
                    <option selected value="board_no">번호순</option>
                    <option value="regdt">최신순</option>
                    <option value="views">조회순</option>
                </select>
                <div id="page">
                    <c:forEach begin="1" end="${page}" var="i">
                        <span onclick="order(${i})">${i}</span>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>