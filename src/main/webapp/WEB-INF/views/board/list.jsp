<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>--%>

<div class="scroll_item">
  <div id="board_container">
      <div id="search_infos">
          <div id="writebtn">
              <button onclick="location.href='write'">write</button>
          </div>
          <div id="searches">
              <form id="search_form">
                  <input type="text" id="searchval" name="searchval">
                  <input type="button" value="검색" onclick="order(${cpage})">
              </form>
              <div id="sap">
                  <select id="orderly" onchange="order(${cpage})">
                      <option selected value="board_no">번호순</option>
                      <option value="regdt">최신순</option>
                      <option value="views">조회순</option>
                  </select>
              </div>
          </div>
      </div>
      <div id="board_lists">
          <table class="tb_board">
                  <tr class="fir_tr">
                      <th>번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>조회</th>
                  </tr>
              <c:forEach var="item" items="${list}" varStatus="status">
                  <tr class="sec_tr" onclick="location.href='detail?board_no=${item.board_no}'">
                      <td>${item.board_no}</td>
                      <td>${item.title}</td>
                      <td>${item.user_no}</td>
                      <td>${item.regdt}</td>
                      <td>${item.views}</td>
                  </tr>
              </c:forEach>
          </table>
      </div>
      <div id="pagearr">
          <c:forEach begin="1" end="${page}" var="num">
              <span onclick="order(${num})">${num}</span>
          </c:forEach>
      </div>
  </div>
</div>