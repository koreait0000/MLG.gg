<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@environment.getProperty('spring.servlet.multipart.location')" var="IMG_SRC"/>

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
    <c:if test="${data.imgArr ne null}">
        <c:forEach var="item" items="${data.imgArr}">
            <span><img src="/pic/board/${item.board_no}/${item.img}"></span>
        </c:forEach>
    </c:if>
    <c:if test="${loginfo.user ne null && loginfo.user.user_no eq data.user_no}">
        <button onclick="location='delete?board_no='+${data.board_no}">글삭제</button>
        <button onclick="upBoard(${data.board_no})">글수정</button>
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
<script>
    function upBoard(board_no) {
        if (confirm("이미지 파일은 삭제됩니다.계속 하시겠습니까?")) {
            location.href = "/board/update?board_no=" +board_no;
        }
    }
</script>