<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/28
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <title>register</title>
</head>
<body>
<div class="form-wrapper">
    <form action = "register.do">
        <div class="header">
            register
        </div>
        <div class="input-wrapper">
            <div class="border-wrapper">
                <input type="text" name="name" placeholder="username" class="border-item">
            </div>
            <div class="border-wrapper">
                <input type="password" name="key" placeholder="password" class="border-item">
            </div>
        </div>

        <div class="action">
            <input type = "submit" value= "register" class = "btn">
        </div>
    </form>
    <div class = "action">
        <div class = "error">${message}</div>
    </div>
</div>
</body>
</html>
