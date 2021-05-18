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
    <script src="<%=request.getContextPath()%>/static/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
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
                        <li><a href="record.do">record</a></li>
                    </ul>
                </li>
                <li class="current_page_item"><a href="drug.do">Drugs</a></li>
                <li><a href="druglabel.do">Drug labels</a></li>
                <li><a href="dosage.do">Dosing Guideline</a></li>
            </ul>
        </div>
    </div>
    <div class="page-headline">Drugs</div>
    <div id="main">
        <div id="content">
            <table class="table">
                <tr>
                    <th>Drug ID</th>
                    <th>Name</th>
                    <th>Drug Url</th>
                    <th>Biomarker</th>
                </tr>
                <c:forEach items="${drugs}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.drugUrl}</td>
                        <td>${item.biomarker}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<div class="cache-images"><img src="static/images/red-button-bg.png" width="0" height="0" alt="" /><img src="static/images/black-button-bg.png" width="0" height="0" alt="" /></div>
<!--end cache-images-->
</html>