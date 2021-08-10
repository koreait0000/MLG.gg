<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <div id="tagsMenu">
        <img class="menuIcon" onclick="byTag(1)" src="https://img.icons8.com/ios-glyphs/40/000000/sword.png"/>
        <img class="menuIcon" onclick="byTag(2)" src="https://img.icons8.com/ios/40/000000/action.png"/>
        <img class="menuIcon" onclick="byTag(3)" src="https://img.icons8.com/windows/40/000000/knife.png"/>
        <img class="menuIcon" onclick="byTag(4)" src="https://img.icons8.com/ios/40/000000/accuracy.png"/>
        <img class="menuIcon" onclick="byTag(5)" src="https://img.icons8.com/plasticine/40/000000/boxing.png"/>
        <img class="menuIcon" onclick="byTag(6)"
             src="https://img.icons8.com/fluency-systems-regular/40/000000/open-book.png"/>
        <img class="menuIcon" onclick="byTag(7)" src="https://img.icons8.com/emoji/40/000000/droplet.png"/>
        <img class="menuIcon" onclick="byTag(8)" src="https://img.icons8.com/nolan/40/boxing.png"/>
        <img class="menuIcon" onclick="byTag(9)" src="https://img.icons8.com/material-outlined/40/000000/like--v2.png"/>
        <img class="menuIcon" onclick="byTag(10)"
             src="https://img.icons8.com/windows/40/000000/armored-breastplate.png"/>
        <img class="menuIcon" onclick="byTag(11)" src="https://img.icons8.com/color/40/000000/armored-breastplate.png"/>
        <img class="menuIcon" onclick="byTag(12)"
             src="https://img.icons8.com/material-outlined/40/000000/hourglass--v1.png"/>
        <img class="menuIcon" onclick="byTag(13)" src="https://img.icons8.com/windows/40/000000/rubber-boots.png"/>
        <img class="menuIcon" onclick="byTag(14)"
             src="https://img.icons8.com/material-rounded/40/000000/monster-mouth.png"/>
        <img class="menuIcon" onclick="byTag(15)" src="https://img.icons8.com/ios-glyphs/40/000000/pie.png"/>
    </div>
    <div id="itemsArea">
        <table id="itemsTable">
            <c:set value="${data}" var="items"></c:set>
            <c:forEach var="item" items="${items}" varStatus="status">
                <span class="itemSpan">
                    <div class="itemDiv1"><img onclick="getItemDetail('${item}')"
                                          style="width: 64px"
                                          src="http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/${item.itemNo}.png">
                    </div>
                    <div class="itemDiv2">${item.total}</div>
                    <div class="itemDiv3">${item.name}</div>
                </span>
            </c:forEach>
        </table>
    </div>
    <div id="itemDetail">
        <div id="intoDiv"></div>
        <div id="imgDiv"></div>
        <div id="totalDiv"></div>
        <div id="infoDiv"></div>
        <div id="statsDiv"></div>
    </div>
</div>