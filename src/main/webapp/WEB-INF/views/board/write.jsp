<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="/board/${mode}" method="post">
        <input type="text" value="${board_data.title}" name="title">
        <input type="text" value="${board_data.ctnt}" name="ctnt">
        <input type="submit" value="${mode}">
        <input type="reset" value="cancel">
    </form>
</div>
