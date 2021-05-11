<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/27
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <link rel="stylesheet" href="static/css/style.css" type="text/css"/>
    <script src="static/js/ie6-transparency.js"></script>
    <script>DD_belatedPNG.fix('#header img, #featured-section h2, #circles img, #frontpage-sidebar .read-more, .blue-bullets li, #sidebar .sidebar-button, #project-content .read-more, .more-link, #contact-form .submit, .jcarousel-skin-tango .jcarousel-next-horizontal, .jcarousel-skin-tango .jcarousel-prev-horizontal, #commentform .submit');</script>
    <style>body { behavior: url("static/css/ie6-hover-fix.htc"); }</style>
    <title>Precision Medicine Matching System</title>
</head>
<body class="page">
<div id="wrap">
    <div id="header"> <h1>Precision Medicine</br> </br>Matching System</h1>
        <div id="nav">
            <ul class="menu">
                <li><a href="continue.do">Home</a></li>
                <li><a href="match.jsp">Matching</a>
                <ul class="sub-menu">
                    <li><a href="record.jsp">record</a></li>
                </ul>
                </li>
                <li><a href="drug.jsp">Drugs</a></li>
                <li class="current_page_item"><a href="druglabel.jsp">Drug labels</a></li>
                <li><a href="dosage.jsp">Dosing Guideline</a></li>
            </ul>
        </div>
    </div>
    <div class="page-headline">Drug Labels</div>
    <div id="main">
        <div id="content">
            <table class="table">
                <tr>
                    <th>#</th>
                    <th>Source</th>
                    <th>Dosing Information</th>
                    <th>Summary Markdown</th>
                </tr>
                <c:forEach items="${drugLabels}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.source}</td>
                        <td>${item.dosingInformation}</td>
                        <td>${item.summaryMarkdown}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="post" >
                <h3 class="post-title"><a href="#">${message}</a></h3>
            </div>
        </div>
    </div>
</div>
</body>
<div class="cache-images"><img src="static/images/red-button-bg.png" width="0" height="0" alt="" /><img src="static/images/black-button-bg.png" width="0" height="0" alt="" /></div>
<!--end cache-images-->
</html>