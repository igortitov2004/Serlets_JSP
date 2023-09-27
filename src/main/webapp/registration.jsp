<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 21.09.2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h3 ><a href="/enterInSystem"  style="color:red;text-decoration: none"  >Назад</a></h3><br>
    <h3> Регистрация </h3>

</head>

<body>
<form action="/addUser" method="post">
    Логин:<input type="text" required  name="login"/><br><br>
    Пароль:<input type="text"  required  name="password"/><br><br>
    Email:<input type="text" required  name="email"/><br><br>
    <input type="submit" value="Подтвердить" />
</form>
</body>
</html>
