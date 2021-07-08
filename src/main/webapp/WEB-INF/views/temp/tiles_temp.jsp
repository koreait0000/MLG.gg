<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="css/chat.css">
</head>
<body>
<header>
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
</header>
<main>
  <tiles:insertAttribute name="content"></tiles:insertAttribute>
</main>
<footer>
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>>
</footer>
<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
<script src="js/chat.js"></script>

</body>
</html>