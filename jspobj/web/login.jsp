<%-- 
    Document   : login
    Created on : 2017-6-25, 17:30:31
    Author     : 45441
--%>

<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id = "reg" scope="request" class="cn.register.demo.Register" />
<body>
<form action="login.jsp" method="post">
	�û�����<input type="text" name="uname"><br>
	��&nbsp;&nbsp;�룺<input type="password" name="upass"><br>
	<input type="submit" value="��½">
	<input type="reset" value="����">
</form>
<%	// ֱ��ͨ��һ���̶����û���������
	String name = request.getParameter("uname") ;
	String password = request.getParameter("upass") ;
	if(!(name==null || "".equals(name) || password==null || "".equals(password))){
		if("lixinghua".equals(name) && "mldn".equals(password)){
			// �����½�ɹ���������session���Է�Χ��
			session.setAttribute("userid",name) ;
			response.setHeader("refresh","2;URL=welcome.jsp") ;
%>
			<h3>�û���½�ɹ����������ת����ӭҳ��</h3>
			<h3>���û����ת���밴<a href="welcome.jsp">����</a>��</h3>
<%
		} else {
%>
			<h3>������û��������룡</h3>
<%
		}
	}
%>

<%	
	String path = application.getRealPath("/") ;
%>
<h3>��ʵ·����<%=path%></h3>
<hr>

  <form action="check.jsp" method ="post">
               <label for="">�û�����</label><input type="text" name="name" value="<jsp:getProperty name="reg" property="name"/>" >
               <%=reg.getErrorMsg("errname")%><br>
               <label for="">���䣺</label><input type="text" name="age" value="<jsp:getProperty name="reg" property="age"/>" >
               <%=reg.getErrorMsg("errage")%><br>
               <label for="">�������䣺</label><input type="text" name="email" value="<jsp:getProperty name="reg" property="email"/>" >
               <%=reg.getErrorMsg("errmail")%><br>
               <input type="submit" value="ע��"><input type="reset" value="����">
          </form>
               
               
</body>
</html>