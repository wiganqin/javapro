<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>你好! This is the default welcome page for a Spring Web MVC project.</p>
        <form action="input.jsp" method ="post">
            <label for="">请输入要显示的内容:</label>
            <input type="text" name="info">
            <input type="submit" value="显示">
        </form>

        
          
    </body>
</html>
