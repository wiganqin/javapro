<%-- 
    Document   : emp_insert_do.jsp
    Created on : 2017-7-2, 0:04:16
    Author     : 45441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="cn.mldn.lxh.factory.*,cn.mldn.lxh.vo.*"%>
<%@ page import="java.text.*"%>
<html>
<head><title>www.mldnjava.cn，MLDN高端Java培训</title></head>
<%	request.setCharacterEncoding("UTF-8");	%>
<body>
<%
	Emp emp = new Emp() ;
	emp.setEmpno(Integer.parseInt(request.getParameter("empno"))) ;
	emp.setEname(request.getParameter("ename")) ;
	emp.setJob(request.getParameter("job")) ;
	emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"))) ;
	emp.setSal(Float.parseFloat(request.getParameter("sal"))) ;
try{
	if(DAOFactory.getIEmpDAOInstance().doCreate(emp)){
%>
		<h3>雇员信息添加成功！</h3>
<%
	} else {
%>
		<h3>雇员信息添加失败！</h3>
<%
	}
%>
<%
}catch(Exception e){
	e.printStackTrace() ;
}
%>
</body>
</html>