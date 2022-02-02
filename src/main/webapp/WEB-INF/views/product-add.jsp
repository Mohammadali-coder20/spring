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
    <form action="/product/save" method="post">
        Name:<input  type ="text" name="name" /><br/>
        Price:<input   type="text" name="price"  /><br/>
        <input type="submit" value="add product"/>
    </form>
</body>
</html>
