<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<div class="row hero-content">
    <div id="tagsMenu">
        <c:forEach begin="1" end="15" var="i">
            <img class="menuIcon" onclick="byTag(${i})" src="${tagurl.url[i]}" id="tag${i}"/>
        </c:forEach>
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

