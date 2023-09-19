<%@ page import="com.example.crudapp.StuffDAO.StuffDAO" %>
<%@ page import="com.example.crudapp.StaffDTO.StuffDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table border="1">
    <tr>
        <th> ID работника</th>
        <th> Имя </th>
        <th> Фамилия </th>
        <th> Номер телефона </th>
        <th> Должность </th>
    </tr>
    <% StuffDAO stuffDAO = new StuffDAO();

   for(StuffDTO stuffDTO:stuffDAO.getListStuff()){
     out.print("<tr><th>"+stuffDTO.getId_staff()+"</th>");
     out.print("<th>"+stuffDTO.getFirstName()+"</th>");
     out.print("<th>"+stuffDTO.getLastName()+"</th>");
     out.print("<th>"+stuffDTO.getPhoneNumber()+"</th>");
     out.print("<th>"+stuffDTO.getRole()+"</th></tr>");
   }
%>
</table>

<%--%>--%>
<%--<tr>--%>
<%--    <th><%= stuffDTO.getId_staff()%> </th>--%>
<%--    <th> <%= stuffDTO.getFirstName()%></th>--%>
<%--    <th> <%= stuffDTO.getLastName()%></th>--%>
<%--    <th> <%= stuffDTO.getPhoneNumber()%></th>--%>
<%--    <th> <%= stuffDTO.getRole()%></th>--%>
<%--</tr>--%>
<%--<%--%>
echo "# Serlets_JSP" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/igortitov2004/Serlets_JSP.git
git push -u origin main


</body>
</html>