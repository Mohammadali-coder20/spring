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
    <table border="1px" style="text-align: center">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${products}" var="productDTO">
            <tr>
                <td>${productDTO.name}</td>
                <td>${productDTO.price}</td>
                <td>X</td>
                <td>E</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
