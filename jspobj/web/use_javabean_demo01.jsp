<%-- 
    Document   : use_javabean_demo01.jsp
    Created on : 2017-6-25, 21:41:43
    Author     : 45441
--%>

<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.mldn.lxh.demo.*"%>
<html>
<head><title>www.mldnjava.cn，MLDN高端Java培训</title></head>
<body>
<%
	SimpleBean simple = new SimpleBean() ;
	simple.setName("李兴华") ;
	simple.setAge(30) ;
%>
<h3>姓名：<%=simple.getName()%></h3>
<h3>年龄：<%=simple.getAge()%></h3>
</body>
</html>