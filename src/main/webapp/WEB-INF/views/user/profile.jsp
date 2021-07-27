<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${loginfo.user.user_no eq data.user_no}">
    <div>같은아이디인지 확인</div>
    <c:if test="${data.lname eq null}">
        <form>
            <input type="text" name="lname">
            <input type="submit" value="저장">
        </form>
    </c:if>
    <c:if test="${data.pname eq null}">
        <form>
            <input type="text" name="pname">
            <input type="submit" value="저장">
        </form>
    </c:if>
</c:if>


