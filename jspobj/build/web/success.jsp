<%-- 
    Document   : success
    Created on : 2017-6-28, 22:20:47
    Author     : 45441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
	request.setCharacterEncoding("UTF-8") ;
%>
<jsp:useBean id="reg" scope="request" class="cn.register.demo.Register"/>
<body>
	用户名：<jsp:getProperty name="reg" property="name"/><br>
	年&nbsp;&nbsp;龄：<jsp:getProperty name="reg" property="age"/><br>
	E-MAIL：<jsp:getProperty name="reg" property="email"/><br>
        <h1>Hello World!</h1>
    </body>
</html>
