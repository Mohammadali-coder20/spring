<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/2/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product list</title>
</head>
<body>
    <table  style="text-align: center; border:solid 1px black">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Detail</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${products}" var="productDTO">
            <tr>
                <td>${productDTO.name}</td>
                <td>${productDTO.price}</td>
<%--                <td><a href="/product/detail?id=${productDTO.id}"><img src="/resources/img/detail.jpg" width="15%" height="15%"/></a></td>--%>
                <td><a href="/product/detail/${productDTO.id}"><img src="/resources/img/detail.jpg" width="15%" height="15%"/></a></td>
                <td><a href="/product/delete"><img src="/resources/img/delete.png" width="15%" height="15%"/></a></td>
                <td><a href="/product/edit"><img src="/resources/img/edit.png" width="15%" height="15%"/></a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
