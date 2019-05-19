<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 05.03.2019
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
</head>

<body>
<nav class="navbar navbar-default navbar-static-top navbar-inverse">
    <a class="navbar-brand" href="/">FirstSpring</a>
    <div class="container">
        <ul class="nav navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="news.htm">News</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.htm">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="carList.htm">CarList</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="bank.htm">Bank</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="bankxml.htm">BankXML</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="calc.htm">Calc</a>
            </li>
        </ul>
    </div>
</nav>
<div style="background-color:powderblue; height: 400px;width: 800px">
    <h1>Автомобили от Делова: выбери любой бесплатно!</h1>
    <table class="activity">
        <tr>
            <th>Марка</th>
            <th>Модель</th>
            <th>Цена</th>
        </tr>
        <c:forEach items = "${carList}" var="car">
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.price}</td>
            </tr>
        </c:forEach>

    </table>
</div>
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
</body>
</html>

