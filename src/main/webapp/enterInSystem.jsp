<%@ page import="com.example.crudapp.StaffDTO.UserDTO" %>
<%@ page import="java.util.Objects" %><%--
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
  <h3>Авторизация</h3>

</head>
<form action="/registration" method="get">

  <input type="submit" value="Регистрация" />
</form>
<body>

<%
  if(request.getParameter("keyEnter") == null){
  UserDTO user = (UserDTO) request.getSession().getAttribute("user");
  if(user!=null){
    response.sendRedirect("/stuff");
  }

}else{
      try{
          for (Cookie cookie:request.getCookies()) {
              Cookie cookie1 = new Cookie(cookie.getName(),"");
              cookie1.setMaxAge(0);
              response.addCookie(cookie1);
          }
      }catch (IndexOutOfBoundsException e){
          e.printStackTrace();
      }
    request.getSession().setAttribute("user",null);
  }%>

<form action="/authorization" method="post">
  Логин:<input type="text" required  name="login"
        <% try{
            for (Cookie cookie:request.getCookies()) {
                if(Objects.equals(cookie.getName(), "login")){%>
               value="<%=cookie.getValue()%>"
        <% break;
        }}
        }catch (RuntimeException e){%>
               value=""
      <%  }%>
/><br><br>
  Пароль:<input type="text"  required  name="password"
        <% try{
            for (Cookie cookie:request.getCookies()) {
                if(Objects.equals(cookie.getName(), "pass")){%>
                value="<%=cookie.getValue()%>"
        <% break;
        }}
        }catch (RuntimeException e){%>
                value=""
        <% }%>
/><br><br>
  <input type="submit" value="Войти" />
</form>


</body>
</html>
