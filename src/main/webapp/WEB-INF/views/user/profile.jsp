<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div id="profile_container">
    <div id="profile_img"> ${pud.mainProfile}프로필사진</div>
    <div id="profile_nm"> ${pud.lname}롤네임</div>
    <c:choose>
        <c:when test="${loginfo.user.user_no eq pud.user_no}">
            <form action="/user/profileImg" method="post" enctype="multipart/form-pud">
                <div>
                    이미지 : <input type="file" name="imgArr" multiple accept="image/*">
                    <input type="submit" value="업로드">
                </div>
            </form>
            <c:if test="${pud.lname eq null}">
                <form>
                    <input type="text" name="lname">
                    <input type="submit" value="저장">
                </form>
            </c:if>
        </c:when>
        <c:otherwise>
            <c:set var="isfollow" value="${false}"></c:set>
            <c:forEach items="${winglist}" var="wingitem">
                <c:if test="${wingitem.uid eq loginfo.user.uid}">
                    <c:set var="isfollow" value="${true}"></c:set>
                </c:if>
            </c:forEach>
            <button onclick="follow(${loginfo.user.uid},${pud.user_no})" id="profile_follow">
                <c:choose>
                    <c:when test="${isfollow}">언팔로우</c:when>
                    <c:otherwise>팔로우</c:otherwise>
                </c:choose>
            </button>
        </c:otherwise>
    </c:choose>
    <div id="follow_list">${woolist.size()}팔로우</div>
    <div id="following_list">${winglist.size()}팔로워</div>
    <div id="profile_info"> 롤정보 레벨및 티어ajax</div>
</div>
