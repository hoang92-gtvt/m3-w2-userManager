<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/26/2021
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>Danh sách người dùng</h1>
    <a href="">Thêm người dùng mới</a> <br>
    <table boder ="1px">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Country</th>

        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.email}</th>
            <th>${user.country}</th>

        </tr>
        </c:forEach>

    </table>

</body>
</html>
