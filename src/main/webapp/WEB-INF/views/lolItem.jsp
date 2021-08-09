<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <span>
        <button onclick="byTag(${data}, 1)">공격력</button>
        <button onclick="byTag(2)">치명타</button>
        <button onclick="byTag(3)">공속</button>
        <button onclick="byTag(4)">적중시 효과</button>
        <button onclick="byTag(5)">방관</button>
        <button onclick="byTag(6)">주문력</button>
        <button onclick="byTag(7)">마나 및 마나재생</button>
        <button onclick="byTag(8)">마관</button>
        <button onclick="byTag(9)">체력 및 체력재생</button>
        <button onclick="byTag(10)">방어력</button>
        <button onclick="byTag(11)">마저</button>
        <button onclick="byTag(12)">쿨감</button>
        <button onclick="byTag(13)">이속</button>
        <button onclick="byTag(14)">흡혈</button>
        <button onclick="byTag(15)">소모품</button>
    </span>
    <div id="itemsArea">
    <c:set value="${data}" var="items"></c:set>
        <c:forEach var="item" items="${items}" varStatus="status">
            <c:if test="${item.total ne 0 && item.itemNo ne 2421
                && item.itemNo ne 2424 && item.itemNo ne 2422
                && item.itemNo ne 2420 && item.itemNo ne 2010
                && item.itemNo ne 4403 && item.itemNo ne 7000
                && item.itemNo ne 3855 && item.itemNo ne 3857
                && item.itemNo ne 3851 && item.itemNo ne 3853
                && item.itemNo ne 3859 && item.itemNo ne 3860
                && item.itemNo ne 3855 && item.itemNo ne 3857
                && item.itemNo ne 3863 && item.itemNo ne 3864}">
                    <span>
                        <img style="width: 64px"
                             src="http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/${item.itemNo}.png">
                        ${item.total}
                        ${item.name}
                    </span>
            </c:if>
            <c:if test="${status.count % 3 == 0}">
                <br>
            </c:if>
        </c:forEach>
    </div>


</div>