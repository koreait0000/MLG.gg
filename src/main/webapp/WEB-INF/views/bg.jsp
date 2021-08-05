<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <img src="/img/bglogo.png" class="img_main">
        <form id="search_summoner" action="getUser" method="get">
            <input type="text" id="search_text" name="search_user" placeholder="소환사명 입력..." value="A_man_">
            <input type="submit" id="btn_search" value="검색">
        </form>
</div>