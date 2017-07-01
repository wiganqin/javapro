<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id = "reg" scope="request" class="cn.register.demo.Register" />
    
    <body>
        <h1>测试首页.</h1>
            
        <form action="page_scope_01.jsp" method ="post">
           
            <input type="text" name="info">
            <input type="submit" value="显示">
        </form>
        
        <form action="login.jsp" method ="post">
          <hr>
            <%	// http://localhost/mldn/
	String path = application.getRealPath("/") ;
            %>
            <h3>真实路径：<%=path%></h3>
            <input type="submit" value="登录页">
        </form>
          <hr>
             <form action="use_javabean_demo01.jsp" method ="post">
          <hr>
          <form action="login.jsp" method ="post">
            <input type="submit" value="javabean">
          </form>
          
          <hr>
          
           <form action="login.jsp" method ="post">
                
               <input type="submit" value="注册"><input type="reset" value="重置">
          </form>
          
    </body>
</html>
