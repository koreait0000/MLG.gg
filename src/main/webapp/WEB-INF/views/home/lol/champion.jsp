<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<h1>챔피언 소리지르는 니가</h1>--%>
<div class="part1">
    <div id="sortMenuArea">
        <c:forEach var="sortMenu" items="${data[0].sort_str}" varStatus="status">
            <div class="sortMenu" onclick="sortChampion(${data[0].sort_no[status.index]}, ${data[0].sort_no[status.count]})">
                    ${data[0].sort_str[status.index]}
            </div>
        </c:forEach>
    </div>

    <div id="championArea">
        <c:forEach var="champion" items="${data}" varStatus="status">
            <div class="nameAndimg" onclick="championDetail('${data[status.index].champion_name}')">
                <img class="championImg" src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${data[status.index].champion_name}_0.jpg">
                <div>${data[status.index].champion_KRname}</div>
            </div>
        </c:forEach>
    </div>

</div>