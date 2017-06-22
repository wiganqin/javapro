<%@ page language="java" import="java.util.*,pojo.Student"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'queryStudent.jsp' starting page</title>

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
		<form action="/t31/StudentSer" method="post">
			关键字
			<input type="text" name="sname" />
			<input type="submit" value="提交" />
			<input type="hidden" name="status" value="queryStudent" />
		</form>
		<table border="1">
			<tr>
				<td>
					编号
				</td>
				<td>
					姓名
				</td>
				<td>
					地址
				</td>
				<td>
					爱好
				</td>
				<td>更新</td>
				<td>删除</td>
			</tr>
			<%
				ArrayList<Student> students = (ArrayList) request
						.getAttribute("students");
				if(students!=null){
				for (int i = 0; i < students.size(); i++) {
			%>
			<tr>
				<td><%=students.get(i).getSid()%></td>
				<td><%=students.get(i).getSname()%></td>
				<td><%=students.get(i).getSaddress()%></td>
				<td><%=students.get(i).getSlikes()%></td>
				<td><a href="/t31/updateStudent.jsp?sid=<%=students.get(i).getSid()%>&sname=<%=students.get(i).getSname()%>&saddress=<%=students.get(i).getSaddress()%>&slikes=<%=students.get(i).getSlikes()%>">更新</a></td>
				<td><a href="/t31/StudentSer?sid=<%=students.get(i).getSid()%>&status=deleteStudent">删除</a></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</body>
</html>
