<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/26/2021
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
    <h1>Form Sửa thông tin</h1>
    <a href="/user?action='home">Trở về home</a><br>
    <form method ="post">
        <div>
            <span>Tên: <input  name ="name" type="text" size="15px"  value="${user.name}"/></span> <br>
            <span>Email: <input  name ="email" type="text" size="15px" value="${user.email}" /></span> <br>
            <span>Quốc tịch: <input  name ="country" type="text" size="15px" value="${user.country}" /></span> <br>

        </div>
        <button type = "submit">Update</button>
    </form>
</body>
</html>
