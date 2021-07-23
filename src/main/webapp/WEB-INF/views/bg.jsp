<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <img src="/img/maokai.png" class="img_main">
    <div class="test1">
        <form id="search_summoner">
            <input type="text" id="search_text" placeholder="소환사명 입력..."
                   value="${loginfo.pname}">
            <input type="submit" id="btn_search" value="검색">
        </form>
    </div>
    <div>BATTLEGROUND</div>
</div>