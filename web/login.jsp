<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/28
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/css/login.css">
    <title>Precision Medicine Matching System</title>
</head>
<div class="form-wrapper">
    <form action = "index.do">
        <div class="header">
            login
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
            <input type = "submit" value = "login" class = "btn">
        </div>
    </form>
    <form action = "register.jsp">
        <div class="action">
            <input type = "submit" value= "register" class = "btn2">
        </div>
    </form>
    <div class = "action">
        <div class = "error">${message}</div>
    </div>
</div>

</body>
</html>
