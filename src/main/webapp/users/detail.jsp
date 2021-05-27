<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/27/2021
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail user</title>
</head>
<body>
<h1>Chi Tiết User</h1>
<a href="/user?action='home">Trở về home</a><br>

    <div>
        <span>Tên: <input  name ="name" type="text" size="15px"  value="${user.name} " disabled/></span> <br>
        <span>Email: <input  name ="email" type="text" size="15px" value="${user.email}" disabled/></span> <br>
        <span>Quốc tịch: <input  name ="country" type="text" size="15px" value="${user.country}" disabled/></span> <br>

    </div>


</body>
</html>
