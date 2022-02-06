<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/1/2022
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<%--<form action="/product/save" method="post">--%>
<%--    Name:<input type="text" name="name"/><br/>--%>
<%--    Price:<input type="text" name="price"/><br/>--%>
<%--    <input type="submit" value="add product"/>--%>
<%--</form>--%>

    <form:form action="/product/save" method="post" modelAttribute="dto">
        <form:errors path="name" cssStyle="color: red"/><br/>
        Name:<form:input path="name"/><br/><br/>
        <form:errors path="price" cssStyle="color: red"/><br/>
        Price:<form:input path="price" /><br/><br/>
        Type:
        <form:select path="type">
            <form:options items="${dto.validTypes}"/>
        </form:select>
        <input type="submit" value="add product"/>
    </form:form>

</body>
</html>
