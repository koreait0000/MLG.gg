<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="google_recaptha">
    <script src='https://www.google.com/recaptcha/api.js'></script>
  <form action="/login" method="POST">
    <div>아이디 : <input type="text" name="uid" ></div>
    <div>비번 : <input type="password" name="upw" ></div>
    <div class="g-recaptcha" data-sitekey="6LdqmoEbAAAAAEMLvDEGEE7mAgeqKuI93xrIOKi_"></div>
    <input type="submit" value="Submit">
  </form>
  <a href="join">sign up</a>
  <div>
    <a href="/oauth2/authorization/naver">네이버</a>
    <a href="/oauth2/authorization/kakao">카카오</a>
    <a href="/oauth2/authorization/google">구글</a>
    <a href="/oauth2/authorization/facebook">페이스북</a>
  </div>
</div>
