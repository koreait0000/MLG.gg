<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div id="google_recaptha">
    <script src='https://www.google.com/recaptcha/api.js'></script>
  <form action="/login" method="POST">
    <div>아이디 : <input type="text" name="uid" ></div>
    <div>비번 : <input type="password" name="upw" ></div>
    <div class="g-recaptcha" data-sitekey="6LdqmoEbAAAAAEMLvDEGEE7mAgeqKuI93xrIOKi_"></div>
    <input type="submit" value="Submit">
  </form>
  <a href="join">회원가입</a>
</div>
