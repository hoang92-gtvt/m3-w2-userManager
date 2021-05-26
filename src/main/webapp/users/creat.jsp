<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/26/2021
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat User</title>
</head>
<body>
    <h1>Form Tạo Mới</h1>
    <a href="/user?action='home'">Quay về trang chủ</a><br>

    <form method="post">
        <div>
            <span>Tên: <input  name ="name" type="text" size="15px" /></span> <br>
            <span>Email: <input  name ="email" type="text" size="15px" /></span> <br>
            <span>Quốc tịch: <input  name ="country" type="text" size="15px" /></span> <br>

        </div>
        <button type = "submit">Tạo mới</button>

    </form>


</body>
</html>
