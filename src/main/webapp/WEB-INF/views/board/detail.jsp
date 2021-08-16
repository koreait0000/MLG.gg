<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@environment.getProperty('spring.servlet.multipart.location')" var="IMG_SRC"/>
<div class="scroll_item">
    <div id="detail_container">
        <span><button class="btn_always" onclick="location.href='list'"><i class="fas fa-list"></i></button></span>
        <div class="header_detail">
            <div class="title_detail">${data.title}</div>
            <span>${data.lname}</span>
            <span>${data.regdt}</span>
            <div>
                <c:if test="${data.imgArr ne null}">
                    <c:forEach var="item" items="${data.imgArr}">
                        <span><img src="/pic/board/${item.board_no}/${item.img}"></span>
                    </c:forEach>
                </c:if>
                <c:if test="${loginfo.user ne null && loginfo.user.user_no eq data.user_no}">
                    <button class="btn_del" onclick="location='delete?board_no='+${data.board_no}"><i
                            class="fas fa-trash-alt"></i></button>
                    <button class="btn_mod" onclick="upBoard(${data.board_no})"><i class="far fa-edit"></i></button>
                </c:if>
            </div>
        </div>
        <div class="content_detail">
            <span>${data.ctnt}</span>
        </div>
        <div class="btn_right_left">
            <c:choose>
                <c:when test="${data.prv > 0}">
                    <button class="btn_previous" onclick="location.href='detail?board_no=${data.prv}'">
                        <i class="fas fa-angle-left"></i>
                    </button>
                </c:when>
                <c:otherwise>
                    <button class="btn_previous" onclick="location.href='list'">
                        <i class="fas fa-ellipsis-h"></i>
                    </button>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${data.nxt ne 0}">
                    <button class="btn_next" onclick="location.href='detail?board_no=${data.nxt}'">
                        <i class="fas fa-angle-right"></i>
                    </button>
                </c:when>
                <c:otherwise>
                    <button class="btn_next" onclick="location.href='list'">
                        <i class="fas fa-ellipsis-h"></i>
                    </button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<script>
    function upBoard(board_no) {
        if (confirm("이미지 파일은 삭제됩니다.계속 하시겠습니까?")) {
            location.href = "/board/update?board_no=" + board_no;
        }
    }
</script>
