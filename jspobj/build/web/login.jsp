<%-- 
    Document   : login
    Created on : 2017-6-25, 17:30:31
    Author     : 45441
--%>

<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn，MLDN高端Java培训</title></head>
<% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id = "reg" scope="request" class="cn.register.demo.Register" />
<body>
<form action="login.jsp" method="post">
	用户名：<input type="text" name="uname"><br>
	密&nbsp;&nbsp;码：<input type="password" name="upass"><br>
	<input type="submit" value="登陆">
	<input type="reset" value="重置">
</form>
<%	// 直接通过一个固定的用户名和密码
	String name = request.getParameter("uname") ;
	String password = request.getParameter("upass") ;
	if(!(name==null || "".equals(name) || password==null || "".equals(password))){
		if("lixinghua".equals(name) && "mldn".equals(password)){
			// 如果登陆成功，则设置session属性范围。
			session.setAttribute("userid",name) ;
			response.setHeader("refresh","2;URL=welcome.jsp") ;
%>
			<h3>用户登陆成功，两秒后跳转到欢迎页！</h3>
			<h3>如果没有跳转，请按<a href="welcome.jsp">这里</a>！</h3>
<%
		} else {
%>
			<h3>错误的用户名或密码！</h3>
<%
		}
	}
%>

<%	
	String path = application.getRealPath("/") ;
%>
<h3>真实路径：<%=path%></h3>
<hr>

  <form action="check.jsp" method ="post">
               <label for="">用户名：</label><input type="text" name="name" value="<jsp:getProperty name="reg" property="name"/>" >
               <%=reg.getErrorMsg("errname")%><br>
               <label for="">年龄：</label><input type="text" name="age" value="<jsp:getProperty name="reg" property="age"/>" >
               <%=reg.getErrorMsg("errage")%><br>
               <label for="">电子邮箱：</label><input type="text" name="email" value="<jsp:getProperty name="reg" property="email"/>" >
               <%=reg.getErrorMsg("errmail")%><br>
               <input type="submit" value="注册"><input type="reset" value="重置">
          </form>
               
               
</body>
</html>