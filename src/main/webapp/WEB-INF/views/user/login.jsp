<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row hero-content">
    <div class="login_container">
        <div id="google_recaptha">
            <script src='https://www.google.com/recaptcha/api.js'></script>
            <form action="/login" method="POST">
                <div><input type="text" name="uid" class="input_id" placeholder="아이디 입력"></div>
                <div><input type="password" name="upw" class="input_pw" placeholder="비밀번호 입력"></div>
                <div class="g-recaptcha" data-sitekey="6LdqmoEbAAAAAEMLvDEGEE7mAgeqKuI93xrIOKi_"></div>
                <br>
                <br>
                <input type="submit" value="로그인" class="input_submit">
            </form>
            <p1>MLG.GG에 처음이세요?</p1>
            <span class="txt_gojoin"><a href="join">회원가입</a></span>
            <div>
                <h3>간편 로그인</h3>
                <%--                네이버--%>
                <button type="button" class="btn_naver">
                    <a href="/oauth2/authorization/naver">NAVER 로그인</a>
                </button>
                <%--                카카오--%>
                <a href="/oauth2/authorization/kakao">
                    <img src="/img/btnkakao.png" class="btn_kakao" width="350px" height="56px">
                </a>
                <%--                구글--%>
                <button type="button" class="btn_google">
                    <span class="txt_google">
                    <a href="/oauth2/authorization/google">
                        <img src="/img/btngoogle.png" class="google-button__img" width="30" height="30">
                        구글 로그인</a>
                    </span>
                </button>
                <%--                페이스북--%>
                <button type="button" class="btn_fb">
                        <span class="txt_fb">
                        <a href="/oauth2/authorization/facebook">
                            <img src="https://member.op.gg/icon_facebook_wh.6ab689d7.svg" class="facebook-button__img"
                                 width="24" height="24" alt="facebook">
                            페이스북으로 로그인</a>
                    </span>
                </button>
            </div>
        </div>
    </div>
</div>