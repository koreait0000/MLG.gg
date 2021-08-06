<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <span>
        <button onclick="byTag()">공격력</button>
        <button onclick="byTag()">치명타</button>
        <button onclick="byTag()">공속</button>
        <button onclick="byTag()">적중시 효과</button>
        <button onclick="byTag()">방관</button>
        <button onclick="byTag()">주문력</button>
        <button onclick="byTag()">마나 및 마나재생</button>
        <button onclick="byTag()">마관</button>
        <button onclick="byTag()">체력 및 체력재생</button>
        <button onclick="byTag()">방어력</button>
        <button onclick="byTag()">마저</button>
        <button onclick="byTag()">쿨감</button>
        <button onclick="byTag()">이속</button>
        <button onclick="byTag()">흡혈</button>
        <button onclick="byTag()">소모품</button>
    </span>
<c:set value="${data}" var="items"></c:set>
    <div id="itemsArea">
        <c:forEach var="item" items="${items}">
            <span>
                <c:if test="${item.total ne 0 && item.itemNo ne 2421
                && item.itemNo ne 2424 && item.itemNo ne 2422
                && item.itemNo ne 2420 && item.itemNo ne 2010
                && item.itemNo ne 4403}" >
                    <img style="width: 64px" src="http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/${item.itemNo}.png">
                    ${item.total}
                    ${item.name}
                </c:if>
            </span>
        </c:forEach>
    </div>




</div>