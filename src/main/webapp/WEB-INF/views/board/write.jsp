<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="scroll_item">
  <div id="write_container">
      <form action="/board/${mode}" method="post" enctype="multipart/form-data">
          <div class="title_submit">
              <input type="text" value="${board_data.title}" name="title" placeholder="제목을 입력해 주세요."></div>
          <div class="ctnt_submit">
              <div class="head_ctnt">이미지 : <input type="file" name="boardimg" multiple accept="image/*"></div>
              <input class="ctnt_write" type="text" value="${board_data.ctnt}" name="ctnt"></div>
          <div class="footer_submit">
              <input type="submit" value="${mode}">
              <input type="reset" value="cancel">
          </div>
      </form>
  </div>
</div>
