<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 21.09.2023
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <h3>Авторизация</h3><br>

</head>
<form action="/registration" method="get">

  <input type="submit" value="Регистрация" />
</form><br>
<body>
<form action="/authorization" method="post">
  Логин:<input type="text" required  name="login"/><br><br>
  Пароль:<input type="text"  required  name="password"/><br><br>
  <input type="submit" value="Войти" />
</form>


</body>
</html>
