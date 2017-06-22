<%-- 
    Document   : page_scope_01.jsp
    Created on : 2017-6-22, 22:15:47
    Author     : 45441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            pageContext.setAttribute("name", "铁牛");
            pageContext.setAttribute("bir", new Date());
        %>
        <%
            String user = (String)pageContext.getAttribute("name");
            Date userbir = (Date)pageContext.getAttribute("bir");
        %>
        
         <h1><%=user%></h1>
         <h1><%=userbir%></h1>
    </body>
</html>
