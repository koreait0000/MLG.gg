<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<c:if test="${loginfo.user.user_no eq data.user_no}">
    <div>같은아이디인지 확인</div>
    <form action="/user/profileImg" method="post" enctype="multipart/form-data">
        <div>
            이미지 : <input type="file" name="imgArr" multiple accept="image/*">
            <input type="submit" value="업로드">
        </div>
    </form>
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
    </form>
    </c:if>
</c:if>


