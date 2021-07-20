<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="s-hero" data-parallax="scroll" data-image-src="/img/wallpaper.jpg" data-natural-width=3000 data-natural-height=2000 data-position-y=center>
    <div class="row hero-content">
    <div class="row hero-content">
        <div class="test1">
            <form id="search_summoner">
                <input type="text" id="search_text" placeholder="소환사명 입력..."
                       value=" ${loginfo.lname}">
                <input type="submit" id="btn_search" value="검색">
            </form>
        </div>
        <div>LEAGUE OF LEGEND</div>
    </div>
    </div>
</section>