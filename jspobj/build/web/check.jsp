<%-- 
    Document   : check
    Created on : 2017-6-28, 22:12:11
    Author     : 45441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% request.setCharacterEncoding("UTF-8");%>
    <jsp:useBean id = "reg" scope="request" class="cn.register.demo.Register" />
    <jsp:setProperty name="reg"  property="*"/>
    <body>
     <%
        if(reg.isValidate()){
      %>  
        <jsp:forward page="success.jsp" />
        <%
        }else{
        %>
        <jsp:forward page="login.jsp" />
        <%
        }
        %>
    </body>
</html>
