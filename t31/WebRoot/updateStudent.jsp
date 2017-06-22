<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body> 
  	更新学生信息 
     <form action="/t31/StudentSer" method="post">
     	姓名:<input type="text" name="sname" value="<%=request.getParameter("sname")%>" /><br/>
     	地址:<input type="text" name="saddress" value="<%=request.getParameter("saddress")%>" /><br/>
     	爱好: 看书<input type="checkbox" name="slikes" value="看书" />
     	上网:<input type="checkbox" name="slikes" value="上网" />
     	旅游:<input type="checkbox" name="slikes" value="旅游" /><br/>
     	<input type="submit" value="提交" />
     	<input type="hidden" name="status" value="updateStudent" />
     	<input type="hidden" name="sid" value="<%=request.getParameter("sid")%>" />
     </form>
  </body>
</html>
