<%-- 
    Document   : use_javabean_demo01.jsp
    Created on : 2017-6-25, 21:41:43
    Author     : 45441
--%>

<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.mldn.lxh.demo.*"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
<%
	SimpleBean simple = new SimpleBean() ;
	simple.setName("���˻�") ;
	simple.setAge(30) ;
%>
<h3>������<%=simple.getName()%></h3>
<h3>���䣺<%=simple.getAge()%></h3>
</body>
</html>