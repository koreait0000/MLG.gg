<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="/board/${mode}" method="post" enctype="multipart/form-data">

        <input type="hidden" value="${board_data.board_no}" name="board_no">
        <input type="text" value="${board_data.title}" name="title">
        <input type="text" value="${board_data.ctnt}" name="ctnt">
        <div>
            이미지 : <input type="file" name="boardimg" multiple accept="image/*">
        </div>
        <input type="submit" value="${mode}">
        <input type="reset" value="cancel">
    </form>


</div>
