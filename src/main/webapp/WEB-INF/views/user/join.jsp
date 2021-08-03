<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">

    <div class="join_container">
        <h3>기본 정보 입력</h3>
        <form action="join" method="post">
            <div id="joinForm">
                <input type="text" class="input_id" name="uid" placeholder="아이디">
                <input type="text" class="input_pw" name="upw" placeholder="비밀번호">
                <input type="text" class="input_lolnick" name="Lname" placeholder="롤 닉네임">
                <input type="text" class="input_bgnick" name="Pname" placeholder="배그 닉네임">
                <input type="submit" class="input_submit" value="가입하기">
            </div>
        </form>
    </div>
</div>