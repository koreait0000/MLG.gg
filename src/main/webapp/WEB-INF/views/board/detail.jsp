<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${data.prv > 0}">
        <button onclick="location.href='detail?board_no=${data.prv}'">이전글</button>
    </c:when>
    <c:otherwise>
        <button onclick="location.href='list'">목록으로</button>
    </c:otherwise>
</c:choose>
<div>
    <span>${data.title}</span>
    <span>${data.ctnt}</span>
    <span>${data.regdt}</span>
    <span>${data.user_no}</span>
    <c:if test="${loginfo.user ne null && loginfo.user.user_no eq data.user_no}">
        <button onclick="location='delete?board_no='+${data.board_no}">글삭제</button><button onclick="location='/board/update?board_no='+${data.board_no}">글수정</button>
    </c:if>
</div>
<button onclick="location.href='list'">항상목록으로</button>
<c:choose>
    <c:when test="${data.nxt ne 0}">
        <button onclick="location.href='detail?board_no=${data.nxt}'">다음글</button>
    </c:when>
    <c:otherwise>
        <button onclick="location.href='list'">목록으로</button>
    </c:otherwise>
</c:choose>
