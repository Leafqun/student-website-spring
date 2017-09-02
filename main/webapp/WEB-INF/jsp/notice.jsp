<%--
  Created by IntelliJ IDEA.
  User: Leafqun
  Date: 2017/5/18
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>通知</title>
</head>
<body>
<div class="head"></div>
<div class="content">
    <h3 class="topic">${notice.noticeName}</h3>
    <div class="noticeBody">${notice.content}</div>
    <p class="file"><a href="../pic/${notice.file}" download="${notice.file}">${notice.file}</a></p>
    <p class="time"><fmt:formatDate value="${notice.noticeTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </p>
</div>
<div class="foot"></div>
</body>
</html>
