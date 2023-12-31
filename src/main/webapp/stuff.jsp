<%@ page import="com.example.crudapp.StuffDAO.StuffDAO" %>
<%@ page import="com.example.crudapp.StaffDTO.StuffDTO" %>
<%@ page import="com.example.crudapp.StaffDTO.UserDTO" %>
<%@ page import="com.example.crudapp.Enum.UserRole" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>

<h3 ><a href="/enterInSystem?keyEnter=1"  style="color:red;text-decoration: none"  >Выйти из аккаунта</a></h3><br>
<body>


    <% StuffDAO stuffDAO = new StuffDAO();
    if(stuffDAO.getListStuff() != null){%>
    <table border="1">
        <tr>
            <th> ID работника</th>
            <th> Имя </th>
            <th> Фамилия </th>
            <th> Номер телефона </th>
            <th> Должность </th>
            <% UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                if(Objects.equals(user.getRole(), UserRole.ADMIN.getTranslate())){%>
            <th> Удаление </th>
            <%
                }%>
            <th> Изменение </th>
        </tr>
<%
     for(StuffDTO stuffDTO:stuffDAO.getListStuff()){
     %>
     <tr>
        <th><%= stuffDTO.getId_staff()%></th>
        <th> <%= stuffDTO.getFirstName()%></th>
        <th> <%= stuffDTO.getLastName()%></th>
        <th> <%= stuffDTO.getPhoneNumber()%></th>
        <th> <%= stuffDTO.getRole()%></th>
         <% if(Objects.equals(user.getRole(), UserRole.ADMIN.getTranslate())){%>
         <th><a href="/deleteStuff?id=<%=stuffDTO.getId_staff()%>" style="text-decoration: none">Удалить</a>
         </th>
          <%
         }%>
         <th><a href="/stuffEdit?id=<%=stuffDTO.getId_staff()%>" style="text-decoration: none">Изменить</a>
         </th>
     </tr>
     <%
     }%> </table> <%
     }else{%>
          <h3>Работники отсутствуют!</h3>
        <%}

%>

<h1>Добавить работника</h1>
<form action="/addStuff" method="post">
    Имя:<input type="text" required id = "firstName" name="firstName"/><br><br>
    Фамилия:<input type="text"  required id = "lastName" name="lastName"/><br><br>
    Номер телефона:<input type="text" required id = "phoneNumber" name="phoneNumber"/><br><br>
    Должность:<input type="text" required id = "role" name="role"/><br><br>
    <input type="submit" value="Добавить работника" />
</form>




</body>
</html>