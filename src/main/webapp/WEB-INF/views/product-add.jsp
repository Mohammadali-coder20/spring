<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
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

    <h2><mvc:message code="product.add" text="add product section"/></h2>
    <a href="?lang=en">EN</a><br/>
    <a href="?lang=fa">fa</a><br/>
    <form:form action="/product/save" method="post" modelAttribute="dto">
        <form:errors path="name" cssStyle="color: red"/><br/>
        Name:<form:input path="name"/><br/><br/>
        <form:errors path="price" cssStyle="color: red"/><br/>
        Price:<form:input path="price" /><br/><br/>
        Type:
        <form:select path="type" cssStyle="width: auto">
            <form:option value="select one option"/>
            <form:options items="${dto.validTypes}"/>
        </form:select>
        <br/>
        choose the color:<br/>
        Green<form:radiobutton path="color" value="green"/>
        blue<form:radiobutton path="color" value="blue"/>
        black<form:radiobutton path="color" value="black"/>
        <br/><br/>
        Sizes:<br/>
        XL<form:checkbox path="sizes" value="4"/>
        L<form:checkbox path="sizes" value="3"/>
        M<form:checkbox path="sizes" value="2"/>
        S<form:checkbox path="sizes" value="1"/>
        <input type="submit" value="add product"/>
    </form:form>

</body>
</html>
