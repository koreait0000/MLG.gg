<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<img src="/img/maokai.png" class="img_main">
<div class="test1">
    <form id="search_summoner">
        <input type="text" id="search_text" placeholder="소환사명 입력..."
        value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.pname}">
        <input type="submit" id="btn_search" value="검색">
    </form>
</div>
    <div>BATTLEGROUND</div>
