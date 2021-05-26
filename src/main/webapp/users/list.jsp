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
    <a href="/user?action=add">Thêm người dùng mới</a> <br>
    <table border="1" style="solid-color: black">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Country</th>
            <th>Sửa</th>
            <th>Xóa</th>
            <th>Detail</th>

        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>

            <td><a href='/user?action=edit&id=${user.id}'>edit</a></td>
            <td><a href="/user?action=delete&id=${user.id}">delete</a></td>
            <td><a href="/user?action=detail&id=${user.id}">detail</a></td>


        </tr>
        </c:forEach>

    </table>

</body>
</html>
