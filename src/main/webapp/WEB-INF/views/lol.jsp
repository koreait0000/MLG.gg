<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="wallpaper-content">
    <div class="hero-content">
        <img class="lolicon" src="/img/opgg.png">
            <form id="search_summoner" action="getID" method="GET">
                <input type="text" id="search_text" name="search_id" placeholder="소환사명 입력...">
                <input type="submit" id="btn_search" value=" ">
            </form>
    </div>
</section>