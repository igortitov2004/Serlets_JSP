<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 21.09.2023
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3 href="/stuff" style="text-decoration: none">Назад</h3><br>
<%  request.getParameter("id"); %>

<h3>Изменение данных о работнике</h3><br>
<form action="/editStuff?id=<%= request.getParameter("id") %>" method="post">
  Имя:<input type="text" required id = "firstName" name="firstName"/><br><br>
  Фамилия:<input type="text"  required id = "lastName" name="lastName"/><br><br>
  Номер телефона:<input type="text" required id = "phoneNumber" name="phoneNumber"/><br><br>
  Должность:<input type="text" required id = "role" name="role"/><br><br>
  <input type="submit" value="Добавить работника" />
</form>

</body>
</html>
