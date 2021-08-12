<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<div class="row hero-content">
    <div id="tagsMenu">
        <img class="menuIcon" onclick="byTag(1)" src="https://img.icons8.com/ios-glyphs/40/000000/sword.png" id="tag1"/>
        <img class="menuIcon" onclick="byTag(2)" src="https://img.icons8.com/ios/40/000000/action.png" id="tag2"/>
        <img class="menuIcon" onclick="byTag(3)" src="https://img.icons8.com/windows/40/000000/knife.png" id="tag3"/>
        <img class="menuIcon" onclick="byTag(4)" src="https://img.icons8.com/ios/40/000000/accuracy.png" id="tag4"/>
        <img class="menuIcon" onclick="byTag(5)" src="https://img.icons8.com/plasticine/40/000000/boxing.png" id="tag5"/>
        <img class="menuIcon" onclick="byTag(6)"
             src="https://img.icons8.com/fluency-systems-regular/40/000000/open-book.png" id="tag6"/>
        <img class="menuIcon" onclick="byTag(7)" src="https://img.icons8.com/emoji/40/000000/droplet.png" id="tag7"/>
        <img class="menuIcon" onclick="byTag(8)" src="https://img.icons8.com/nolan/40/boxing.png" id="tag8"/>
        <img class="menuIcon" onclick="byTag(9)" src="https://img.icons8.com/material-outlined/40/000000/like--v2.png" id="tag9"/>
        <img class="menuIcon" onclick="byTag(10)"
             src="https://img.icons8.com/windows/40/000000/armored-breastplate.png" id="tag10"/>
        <img class="menuIcon" onclick="byTag(11)" src="https://img.icons8.com/color/40/000000/armored-breastplate.png" id="tag11"/>
        <img class="menuIcon" onclick="byTag(12)"
             src="https://img.icons8.com/material-outlined/40/000000/hourglass--v1.png" id="tag12"/>
        <img class="menuIcon" onclick="byTag(13)" src="https://img.icons8.com/windows/40/000000/rubber-boots.png" id="tag13"/>
        <img class="menuIcon" onclick="byTag(14)"
             src="https://img.icons8.com/material-rounded/40/000000/monster-mouth.png" id="tag14"/>
        <img class="menuIcon" onclick="byTag(15)" src="https://img.icons8.com/ios-glyphs/40/000000/pie.png" id="tag15"/>
    </div>
    <div id="itemsArea">
        <table id="itemsTable">
            <c:set value="${data}" var="items"></c:set>
            <c:forEach var="item" items="${items}" varStatus="status">
                <span class="itemSpan" onclick="clickEnt(${item.itemNo})">
                    <div class="itemDiv1"><img id="itemimg${status.index}" class="itemimg"
                                          style="width: 64px"
                                          src="http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/${item.itemNo}.png">
                    </div>
                    <div class="itemDiv3">${item.name}</div>
                </span>
            </c:forEach>
        </table>
    </div>
    <div id="itemDetail">
        <div class="intoDiv"></div>
        <div class="dragDiv"></div>
        <div class="imgDiv"></div>
        <div class="totalDiv"></div>
        <div class="infoDiv"></div>
        <div class="statsDiv"></div>
    </div>
</div>
<script>

</script>

